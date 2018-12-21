package bin

import ApplicationLogger
import javafx.application.Platform
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels

class DownloadUpdateTool {
    companion object {
        fun download() {
            ApplicationLogger.logger.info("Downloading SacredMagician updater utility ...")

            val rbc = Channels.newChannel(URL("https://drive.google.com/uc?export=download&id=1QAPcDsa_gg0T2RdH42kmWTPjaRYv9oqx").openStream())
            val fos = FileOutputStream("updater.jar")
            fos.channel.transferFrom(rbc, 0, java.lang.Long.MAX_VALUE)
            fos.close()

            ApplicationLogger.logger.info("Downloading SacredMagician updater utility done!")
            Platform.runLater { ShowUpdateNowItem.show() }
        }
    }
}