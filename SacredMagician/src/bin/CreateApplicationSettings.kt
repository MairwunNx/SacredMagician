package bin

import ApplicationLogger
import ApplicationPaths
import java.io.File

class CreateApplicationSettings {
    companion object {
        fun create() {
            if (GetAvailabilitySettings.get(ApplicationPaths.appSettingsFile)) return

            val initialStream = CreateApplicationSettings::class.java.getResourceAsStream("/cfg/app.setg.toml")
            File(ApplicationPaths.appSettingsFile).outputStream().use { initialStream.copyTo(it) }

            ApplicationLogger.logger.info("SacredMagician application settings was successfully created!")
        }
    }
}