package bin

import ApplicationSummary
import java.io.FileInputStream

class GetBinDataByOffset {
    fun get(offset: Long): Int {
        val fileInputStream = FileInputStream(ApplicationSummary().binPath)
        return ConvertBytesToInt().convert(fileInputStream, offset)
    }
}