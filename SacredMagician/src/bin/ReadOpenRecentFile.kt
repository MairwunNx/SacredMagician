package bin

import ApplicationLogger
import java.io.File
import java.util.*

class ReadOpenRecentFile {
    companion object {
        fun read(): Array<String> {
            ApplicationLogger.logger.info("Loading saved open recent path's ...")

            val lines = ArrayList<String>()

            File("\$SacredMagician\\conf\\app.rcnt.txt").readLines().forEach {
                if (File(it).exists() && File(it).isFile) lines.add(it)
            }

            return lines.toTypedArray()
        }
    }
}