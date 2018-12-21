package bin

import java.io.File

class GetAvailabilitySettings {
    companion object {
        fun get(settingFile: String): Boolean = (File(settingFile).exists() && !File(settingFile).isDirectory)
    }
}