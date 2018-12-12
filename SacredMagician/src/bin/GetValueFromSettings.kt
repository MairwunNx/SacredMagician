package bin

import ApplicationLogger
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

class GetValueFromSettings {
    companion object {
        fun getBoolean(path: String, name: String): Boolean {
            try {
                val configurationFuncName = "$name = "

                val configuration = readConfiguration(path)

                val funcName = configuration.firstOrNull { s: String ->
                    s.startsWith(configurationFuncName)
                } ?: return false

                return funcName.substring(configurationFuncName.length) == "true"
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while getting bool value from file: \"$path\", from \"$name\"")

                val sw = StringWriter()
                ex.printStackTrace(PrintWriter(sw))
                val exceptionAsString = "$sw"
                ApplicationLogger.logger.error(exceptionAsString)

                return false
            }
        }

        fun getInteger(path: String, name: String): Int {
            try {
                val configurationFuncName = "$name = "

                val configuration = readConfiguration(path)

                val funcName = configuration.firstOrNull { s: String ->
                    s.startsWith(configurationFuncName)
                } ?: return 0

                return funcName.substring(configurationFuncName.length).toInt()
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while getting integer value from file: \"$path\", from \"$name\"")

                val sw = StringWriter()
                ex.printStackTrace(PrintWriter(sw))
                val exceptionAsString = "$sw"
                ApplicationLogger.logger.error(exceptionAsString)

                return 0
            }
        }

        private fun readConfiguration(path: String): Array<String> {
            val scanner = Scanner(File(path))
            val lines = ArrayList<String>()

            while (scanner.hasNextLine()) lines.add(scanner.nextLine())

            scanner.close()

            return lines.toTypedArray()
        }
    }
}