package bin

import ApplicationLogger
import java.io.File

class CreateTelemetrySettings {
    companion object {
        fun create() {
            if (GetAvailabilitySettings.get("\$SacredMagician\\conf\\app.stat.toml")) return

            val initialStream = CreateApplicationSettings::class.java.getResourceAsStream("/cfg/app.stat.toml")
            File("\$SacredMagician\\conf\\app.stat.toml").outputStream().use { initialStream.copyTo(it) }

            ApplicationLogger.logger.info("SacredMagician telemetry settings was successfully created!")
        }
    }
}