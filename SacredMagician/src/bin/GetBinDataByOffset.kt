package bin

import ApplicationLogger
import ApplicationSummary
import java.io.FileInputStream
import java.io.PrintWriter
import java.io.StringWriter

class GetBinDataByOffset {
    fun get(offset: Long, isFloat: Boolean): Number {
        return try {
            val fileInputStream = FileInputStream(ApplicationSummary.binPath)

            val result = ConvertBytesToInt().convert(fileInputStream, offset, isFloat)

            ApplicationLogger().logger.info("Loaded data by bytes: $result, offset: $offset")

            result
        } catch (ex: Exception) {
            ApplicationLogger().logger.error("An error occurred while loading data bytes on $offset")

            val sw = StringWriter()
            ex.printStackTrace(PrintWriter(sw))
            val exceptionAsString = "$sw"
            ApplicationLogger().logger.error(exceptionAsString)

            0
        }
    }
}