package bin

import ApplicationLogger
import ApplicationPaths
import java.io.File

class CreateTelemetrySettings {
    companion object {
        fun create() {
            if (GetAvailabilitySettings.get(ApplicationPaths.appStatisticFile)) return

            val initialStream = CreateApplicationSettings::class.java.getResourceAsStream("/cfg/app.stat.toml")
            File(ApplicationPaths.appStatisticFile).outputStream().use { initialStream.copyTo(it) }

            ApplicationLogger.logger.info("SacredMagician telemetry settings was successfully created!")
        }
    }
}