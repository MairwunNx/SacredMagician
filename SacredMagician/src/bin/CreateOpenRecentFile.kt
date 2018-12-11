package bin

import ApplicationLogger
import java.io.File

class CreateOpenRecentFile {
    companion object {
        fun create() {
            val openRecentFile = File("\$SacredMagician\\conf\\app.rcnt.txt")
            openRecentFile.createNewFile()

            ApplicationLogger.logger.info("Open recent file has been successfully created!")
        }
    }
}