package bin

import ApplicationPaths
import ApplicationSummary
import java.io.File

class AddFilePathToRecent {
    companion object {
        fun add() {
            val file = File(ApplicationPaths.openRecentFile)
            val fileText = file.readText()

            if (fileText.contains(ApplicationSummary.binPath, true)) return

            file.appendText(ApplicationSummary.binPath + System.getProperty("line.separator"))
        }
    }
}