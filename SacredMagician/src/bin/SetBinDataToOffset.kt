package bin

import ApplicationSummary
import java.io.RandomAccessFile

class SetBinDataToOffset {
    fun setInt(neededNumber: Number, offset: Int) {
        val raf = RandomAccessFile(ApplicationSummary().binPath, "rw")

        val offset = offset

        val ss = ConvertNumToByteArray().convertFromInt(neededNumber)

        raf.seek(offset.toLong())
        raf.write(ss)
        raf.close()
    }

    fun setFloat(neededNumber: Number, offset: Int) {
        val raf = RandomAccessFile(ApplicationSummary().binPath, "rw")

        val offset = offset

        val ss = ConvertNumToByteArray().convertFromFloat(neededNumber)

        raf.seek(offset.toLong())
        raf.write(ss)
        raf.close()
    }
}