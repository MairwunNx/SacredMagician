package bin

import ApplicationLogger
import java.io.File

class RemoveAppTempFiles {
    companion object {
        private val temporaryFiles = arrayOf("updater.jar", "_newVersionSacredMagicianTemp.jar", "updargs.txt")

        fun remove() {
            temporaryFiles.forEach {
                if (getAvailabilityTempContent(it)) {
                    try {
                        File(it).delete()
                    } catch (ex: Exception) {
                        ApplicationLogger.logger.error("An error occurred while removing temporary file $it")
                        AppPrintStackTrace.print(ex)
                    }
                }
            }
        }

        private fun getAvailabilityTempContent(tempFileName: String): Boolean {
            val file = File(tempFileName)

            return (file.exists() && !file.isDirectory)
        }
    }
}