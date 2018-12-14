package bin

import ApplicationSummary
import java.io.File

class AddFilePathToRecent {
    companion object {
        fun add() {
            val file = File("\$SacredMagician\\conf\\app.rcnt.txt")
            val fileText = file.readText()

            if (fileText.contains(ApplicationSummary.binPath, true)) return

            file.appendText(ApplicationSummary.binPath + System.getProperty("line.separator"))
        }
    }
}