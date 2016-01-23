package ch.ninecode

import java.io.FileInputStream

import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2

//// NOTE: in order to get maven and scala to work together in Eclipse
//// I needed to install the maven-scala plugin from here:
//// http://alchim31.free.fr/m2e-scala/update-site/

/**
 * Wrapper class for CIM.
 *
 * This class isolates the Spark related dependencies, so the CIM
 * class remains unencumbered by the heavy overhead.
 *
 */
object CIMRDD
{
    def rddFile (sc: SparkContext, filename: String, offset: Long = 0, length: Long = 0): RDD[(String, Element)] =
    {
        var size: Long = length
        if (0 == size)
        {
            val fis = new FileInputStream (filename)
            size = fis.available () - offset
            fis.close ();
            println ("file size: %d bytes".format (size))
        }
        val xml = CIM.read (filename, offset, size)
        val parser = new CIM ()
        val result = parser.parse (xml)
        return (sc.parallelize (result.PowerSystemResources.toSeq))
    }

    def main (args:Array[String])
    {
        val conf = new SparkConf ().setAppName ("CIMScala")
//        val master = if (args.size > 0) args (0) else "local"
//        conf.setMaster (master)
        val spark = new SparkContext (conf)

        try
        {
            if (args.size > 0)
            {
                // set up the SQL context
                val sql_context = new HiveContext (spark)
                println ("context established")

                // start the thrift JDBC server on port 10000
                HiveThriftServer2.startWithContext (sql_context)
                println ("thriftserver started")

                // create an RDD by reading in the datafile
                val filename = args (0)
                val rdd = rddFile (spark, filename, 0, 0)
                println ("rdd created")

                // extract the locations as a new RDD
                val pf: PartialFunction[(String, ch.ninecode.Element), (String, ch.ninecode.Location)] =
                {
                    case x: (String, Any)
                        if x._2.getClass () == classOf[ch.ninecode.Location] ⇒ (x._1, x._2.asInstanceOf[ch.ninecode.Location])
                }
                val locations = rdd.collect (pf)
                // locations.persist ()
                println ("collected " + locations.count () + " locations")

                // create a dataframe from the locations
                val mydataframe = sql_context.createDataFrame (locations)
                println ("dataframe created")

                // expose the dataframe as a table
                mydataframe.registerTempTable ("locations")
                println ("locations table created")

                // wait for 120 seconds
                Thread.sleep (120000)

                println ("time's up")
            }
            else
                println ("CIM XML input file not specified")
        }
        finally
        {
            spark.stop ();
        }
    }
}
