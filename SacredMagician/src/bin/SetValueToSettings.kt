package bin

import ApplicationLogger
import java.io.File
import java.io.FileWriter

class SetValueToSettings {
    companion object {
        fun setValue(path: String, name: String, value: String) {
            val configurationFuncName = "$name = "

            val file = readConfiguration(path)

            try {
                if (file.contains(name)) {
                    val text: Array<String> = File(path).readLines().toTypedArray()

                    var j = -1
                    for (i in text) {
                        j++
                        if (i.contains(configurationFuncName)) {
                            text[j] = "$configurationFuncName$value"
                            File(path).writeText(text.joinToString("\n"))
                        }
                    }
                } else {
                    val fileWriter = FileWriter(path, true)
                    fileWriter.write("\n$configurationFuncName$value")
                    fileWriter.close()
                }
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while setting some value: $value for file: \"$path\", for \"$name\"")
                AppPrintStackTrace.print(ex)
            }
        }

        private fun readConfiguration(path: String): String = File(path).readText()
    }
}