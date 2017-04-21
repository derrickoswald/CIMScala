package ch.ninecode.cim

import org.apache.commons.logging.LogFactory
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext
import org.apache.hadoop.mapreduce.lib.input.FileSplit
import org.apache.hadoop.io.Text
import org.apache.spark.sql.Row

import ch.ninecode.model.CHIM
import ch.ninecode.model.Element

class CIMRecordReader extends RecordReader[String, Element]
{
    val LocalLog = LogFactory.getLog (classOf[CIMRecordReader])
    var cim: CHIM = null

    def initialize (genericSplit: InputSplit, context: TaskAttemptContext): Unit =
    {
        LocalLog.info ("initialize")
        LocalLog.info ("genericSplit: " + genericSplit.toString ())
        LocalLog.info ("context: " + context.toString ())
        val job = context.getConfiguration ()
        val split = genericSplit.asInstanceOf[FileSplit]
        val start = split.getStart ()
        val end = start + split.getLength ()
        val file = split.getPath ()

        // open the file and seek to the start of the split
        val fs = file.getFileSystem (job)
        val in = fs.open (file)

        val extra = if (in.available () > end) CHIM.OVERREAD else 0
        // ToDo: may need to handle block sizes bigger than 2GB - what happens for size > 2^31?
        val size = (end - start + extra).toInt
        val buffer = new Array[Byte] (size)
        in.readFully (start, buffer)

        val low =
            if (0 == start)
                // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
                if ((size >= 3) && (buffer(0) == 0xef) && (buffer(1) == 0xbb) && (buffer(2) == 0xbf))
                    3
                else
                    0
            else
                0

        val first =
            if (0 != start)
            {
                // skip to next UTF-8 non-continuation byte (high order bit zero)
                // by advancing past at most 4 bytes
                var i = 0
                if ((buffer(low + i) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
                    while (0 != (buffer(low + i) & 0x80) && (i < Math.min (4, size)))
                        i += 1
                low + i
            }
            else
                low

        val len = Text.decode (buffer, first, size - first - extra).length
        val xml = Text.decode (buffer, first, size - first)

        // ToDo: using first here is approximate,
        // the real character count would require reading the complete file
        // from 0 to (start + first) and converting to characters
        LocalLog.info ("XML text starting at byte offset " + (start + first) + " of length " + len + " characters begins with: " + xml.substring (0, 120))
        cim = new CHIM (xml, first, first + len)
    }

    def close (): Unit =
    {
        LocalLog.info ("close")
        cim = null
    }

    def getCurrentKey (): String = cim.value.id

    def getCurrentValue (): Element = cim.value

    def getProgress (): Float = cim.progress

    def nextKeyValue (): Boolean = cim.parse_one
}
