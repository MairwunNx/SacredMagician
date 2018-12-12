package bin

import ApplicationLogger
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

class GetValueFromSettings {
    companion object {
        fun getValue(path: String, name: String): String {
            try {
                val configurationFuncName = "$name = "

                val configuration = readConfiguration(path)

                val funcName = configuration.firstOrNull { s: String ->
                    s.startsWith(configurationFuncName)
                } ?: return "null"

                return funcName.substring(configurationFuncName.length)
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while getting some value from file: \"$path\", from \"$name\"")

                val sw = StringWriter()
                ex.printStackTrace(PrintWriter(sw))
                val exceptionAsString = "$sw"
                ApplicationLogger.logger.error(exceptionAsString)

                return "null"
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