package bin

import ApplicationLogger
import ApplicationPaths
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels

class DownloadNewUpdate {
    companion object {
        fun download(update: String) {
            val readableByteChannel = Channels.newChannel(URL(update).openStream())
            val fileOutputStream = FileOutputStream(ApplicationPaths.newUpdateFile)

            fileOutputStream.channel.transferFrom(readableByteChannel, 0, java.lang.Long.MAX_VALUE)
            fileOutputStream.close()

            ApplicationLogger.logger.info("Downloading SacredMagician application update done!")
            DownloadUpdateTool.download()
        }
    }
}