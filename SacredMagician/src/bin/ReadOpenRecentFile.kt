package bin

import java.io.File
import java.util.*

class ReadOpenRecentFile {
    companion object {
        fun read(): Array<String> {
            ApplicationLogger.logger.info("Loading saved open recent path's ...")

            val sc = Scanner(File("\$SacredMagician\\conf\\app.rcnt.txt"))
            val lines = ArrayList<String>()

            while (sc.hasNextLine()) lines.add(sc.nextLine())

            return lines.toTypedArray()
        }
    }
}