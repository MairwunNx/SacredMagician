package bin

import ApplicationLogger
import ApplicationSummary
import java.io.PrintWriter
import java.io.StringWriter
import java.net.InetSocketAddress
import java.net.Socket

class GetInternetConnection {
    companion object {
        private fun getConnection(): Boolean {
            var status = false
            val sock = Socket()
            val address = InetSocketAddress("www.google.com", 80)

            try {
                sock.connect(address, 3000)
                if (sock.isConnected) status = true
            } catch (e: Exception) {
                status = false
            } finally {
                try {
                    sock.close()
                } catch (ex: Exception) {
                    val sw = StringWriter()
                    ex.printStackTrace(PrintWriter(sw))
                    val exceptionAsString = "$sw"
                    ApplicationLogger.logger.error(exceptionAsString)
                }
            }

            return status
        }

        fun getCurrentSessionStatus() {
            if (getConnection()) {
                ApplicationLogger.logger.info("SacredMagician current application running in online mode!")
                ApplicationSummary.isOnline = true
            } else {
                ApplicationLogger.logger.warn("SacredMagician current application running in offline mode!")
                ApplicationSummary.isOnline = false
            }
        }
    }
}