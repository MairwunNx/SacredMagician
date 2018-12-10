package bin

import ApplicationLogger
import ApplicationSummary
import java.io.PrintWriter
import java.io.RandomAccessFile
import java.io.StringWriter

class SetBinDataToOffset {
    fun setInt(neededNumber: Number, offset: Int) {
        try {
            val raf = RandomAccessFile(ApplicationSummary.binPath, "rw")

            val ss = ConvertNumToByteArray().convertFromInt(neededNumber)

            raf.seek(offset.toLong())
            raf.write(ss)
            raf.close()

            ApplicationLogger().logger.info("Successfully write data: $neededNumber to $offset!")
        } catch (ex: Exception) {
            ApplicationLogger().logger.error("An error occurred while writing data bytes on $offset")

            val sw = StringWriter()
            ex.printStackTrace(PrintWriter(sw))
            val exceptionAsString = "$sw"
            ApplicationLogger().logger.error(exceptionAsString)
        }
    }

    fun setFloat(neededNumber: Number, offset: Int) {
        try {
            val raf = RandomAccessFile(ApplicationSummary.binPath, "rw")

            val ss = ConvertNumToByteArray().convertFromFloat(neededNumber)

            raf.seek(offset.toLong())
            raf.write(ss)
            raf.close()

            ApplicationLogger().logger.info("Successfully write data: $neededNumber to $offset!")
        } catch (ex: Exception) {
            ApplicationLogger().logger.error("An error occurred while writing data bytes on $offset")

            val sw = StringWriter()
            ex.printStackTrace(PrintWriter(sw))
            val exceptionAsString = "$sw"
            ApplicationLogger().logger.error(exceptionAsString)
        }
    }
}