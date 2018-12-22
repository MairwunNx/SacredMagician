package bin

import ApplicationLogger
import java.io.File
import java.util.*

class ReadOpenRecentFile {
    companion object {
        fun read(): Array<String> {
            ApplicationLogger.logger.info("Loading saved open recent path's ...")

            val sc = Scanner(File("\$SacredMagician\\conf\\app.rcnt.txt"))
            val lines = ArrayList<String>()

            sc.forEach {
                if (File(it).exists() && File(it).isFile) lines.add(it)
            }

            return lines.toTypedArray()
        }
    }
}