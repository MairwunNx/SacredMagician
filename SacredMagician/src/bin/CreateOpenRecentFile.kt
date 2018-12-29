package bin

import ApplicationLogger
import ApplicationPaths
import java.io.File

class CreateOpenRecentFile {
    companion object {
        fun create() {
            File(ApplicationPaths.openRecentFile).createNewFile()
            ApplicationLogger.logger.info("Open recent file has been successfully created!")
        }
    }
}