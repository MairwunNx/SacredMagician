package bin

import java.io.File

class GetAvailabilitySettings {
    companion object {
        fun get(settingFile: String): Boolean {
            val file = File(settingFile)

            return (file.exists() && !file.isDirectory)
        }
    }
}