package bin

import ApplicationLogger
import java.io.File

class CreateDirectories {
    fun createDirectories() {
        ApplicationDirectories().directoriesArray.forEach { i ->
            val directory = File(i)

            directory.mkdirs()

            ApplicationLogger().logger.info("Directory $i was created successfully!")
        }
    }
}