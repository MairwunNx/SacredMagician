package bin

import java.io.File

class GetAvailabilitySettings {
    companion object {
        fun get(): Boolean {
            val file = File("\$SacredMagician\\conf\\app.setg.toml")

            return (file.exists() && !file.isDirectory)
        }
    }
}