package bin

import ApplicationLogger
import java.io.File

class CreateApplicationSettings {
    companion object {
        fun create() {
            if (GetAvailabilitySettings.get("\$SacredMagician\\conf\\app.setg.toml")) return

            val initialStream = CreateApplicationSettings::class.java.getResourceAsStream("/cfg/app.setg.toml")
            File("\$SacredMagician\\conf\\app.setg.toml").outputStream().use { initialStream.copyTo(it) }

            ApplicationLogger.logger.info("SacredMagician application settings was successfully created!")
        }
    }
}