package bin

import ApplicationLogger
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels

class DownloadNewUpdate {
    companion object {
        fun download(update: String) {
            val website = URL(update)
            val rbc = Channels.newChannel(website.openStream())
            val fos = FileOutputStream("_newVersionSacredMagicianTemp.jar")
            fos.channel.transferFrom(rbc, 0, java.lang.Long.MAX_VALUE)
            fos.close()

            ApplicationLogger.logger.info("Downloading SacredMagician application update done!")

            DownloadUpdateTool.download()
        }
    }
}