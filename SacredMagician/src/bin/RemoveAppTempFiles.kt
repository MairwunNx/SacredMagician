package bin

import ApplicationLogger
import java.io.File

class RemoveAppTempFiles {
    companion object {
        private val temporaryFiles = arrayOf("updater.jar", "_newVersionSacredMagicianTemp.jar")

        fun remove(args: Array<String>) {
            if (args.contains("-disableRemoveTemp")) return

            temporaryFiles.forEach {
                if (getAvailabilityTempContent(it)) try {
                    File(it).delete()
                } catch (ex: Exception) {
                    ApplicationLogger.logger.error("An error occurred while removing temporary file $it")
                    AppPrintStackTrace.print(ex)
                }
            }
        }

        private fun getAvailabilityTempContent(tempFileName: String): Boolean =
                (File(tempFileName).exists() && !File(tempFileName).isDirectory)
    }
}