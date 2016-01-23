package ch.ninecode

import scala.xml._

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import org.junit.runner.RunWith
import org.scalatest.fixture
import org.scalatest.junit.JUnitRunner
import org.scalatest.Outcome

class CIMSuite extends fixture.FunSuite
{
    type FixtureParam = SparkContext


    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture
        val configuration = new SparkConf()
        configuration.setAppName ("CIMSuite")
        configuration.setMaster ("local[2]")
        val context = new SparkContext (configuration)
        try
        {
            withFixture (test.toNoArgTest (context)) // "loan" the fixture to the test
        }
        finally context.stop () // clean up the fixture
    }

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/2.2.4/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */
    test ("Basic")
    {
        sc ⇒
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CIM ()
        val result = parser.parse (xml)
        assert (result.PowerSystemResources.size === 1)
    }

    test ("Forward Reference")
    {
        sc ⇒
        // Note: scala really hates processing instructions:
        // <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:ConnectivityNode rdf:ID="_pin_1555190">
                    <cim:IdentifiedObject.name>PIN16</cim:IdentifiedObject.name>
                    <cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource="_subnetwork_183839"/>
                </cim:ConnectivityNode>
                <cim:Line rdf:ID="_subnetwork_183839">
                    <cim:IdentifiedObject.name>ABG2682|FLT22|FLU74|FLU75|HAS997|PIN16</cim:IdentifiedObject.name>
                </cim:Line>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        val container = result.PowerSystemResources.apply ("_subnetwork_183839").asInstanceOf[Container]
        assert (container.contents.size === 1)
        assert (container.contents.contains ("_pin_1555190"))
    }

    test ("Voltage")
    {
        sc ⇒
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                        <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                        <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
                </cim:BaseVoltage>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        val voltage = result.PowerSystemResources.apply ("BaseVoltage_0.400000000000").asInstanceOf[Voltage]
        assert (voltage.voltage === 400)
    }

    test ("Illegal Voltage")
    {
        sc ⇒
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                        <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                        <cim:BaseVoltage.nominalVoltage>x.400000000000</cim:BaseVoltage.nominalVoltage>
                </cim:BaseVoltage>
            </rdf:RDF>;
        val parser = new CIM ()
        intercept[Exception]
        {
            val result = parser.parse (xml.toString ())
            fail ("invalid voltage accepted")
        }
    }

    test ("Coordinate System")
    {
        sc ⇒
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:CoordinateSystem rdf:ID="wgs_84">
                    <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
                    <cim:crsUrn>EPSG::4326</cim:crsUrn>
                </cim:CoordinateSystem>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        assert (result.PowerSystemResources.size === 1)
        val cs = result.PowerSystemResources apply "wgs_84"
        assert (cs.isInstanceOf[CoordinateSystem])
        val cs2 = cs.asInstanceOf[CoordinateSystem]
        assert (cs2.urn === "EPSG::4326")
    }

    test ("Create")
    {
        sc ⇒
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CIM ()
        val result = parser.parse (xml)
        assert (result.PowerSystemResources.size === 1)
        val rdd = sc.parallelize (result.PowerSystemResources.toSeq, 2)
        assert (rdd.count () === 1)
    }

    test ("Read")
    {
        sc ⇒
        val rdd = CIMRDD.rddFile (sc, "data/dump_all.xml", 0, 0)
        assert (rdd.count () === 203046)
    }
}
