package bin

import ApplicationSummary
import java.io.FileInputStream

class GetBinDataByOffset {
    fun get(offset: Long, isFloat: Boolean): Number {
        val fileInputStream = FileInputStream(ApplicationSummary().binPath)
        return ConvertBytesToInt().convert(fileInputStream, offset, isFloat)
    }
}