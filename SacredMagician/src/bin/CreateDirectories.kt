package bin

import ApplicationLogger
import java.io.File

class CreateDirectories {
    companion object {
        fun createDirectories() {
            ApplicationDirectories.directoriesArray.forEach { i ->
                File(i).mkdirs()
                ApplicationLogger.logger.info("Directory $i was created successfully!")
            }
        }
    }
}