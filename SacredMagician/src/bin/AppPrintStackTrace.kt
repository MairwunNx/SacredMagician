package bin

import ApplicationLogger
import java.io.PrintWriter
import java.io.StringWriter

class AppPrintStackTrace {
    companion object {
        fun print(ex: Exception) {
            val sw = StringWriter()
            ex.printStackTrace(PrintWriter(sw))

            val exceptionAsString = sw.toString()
            ApplicationLogger.logger.error(exceptionAsString)
        }
    }
}