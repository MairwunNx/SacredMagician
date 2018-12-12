package bin

import java.io.File

class CreateApplicationSettings {
    companion object {
        fun create() {
            if (GetAvailabilitySettings.get()) return

            val initialStream = javaClass.getResourceAsStream("/cfg/app.setg.toml")

            File("\$SacredMagician\\conf\\app.setg.toml").outputStream().use { initialStream.copyTo(it) }
        }
    }
}