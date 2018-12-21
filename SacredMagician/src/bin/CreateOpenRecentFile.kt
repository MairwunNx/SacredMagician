package bin

import ApplicationLogger
import java.io.File

class CreateOpenRecentFile {
    companion object {
        fun create() {
            File("\$SacredMagician\\conf\\app.rcnt.txt").createNewFile()
            ApplicationLogger.logger.info("Open recent file has been successfully created!")
        }
    }
}