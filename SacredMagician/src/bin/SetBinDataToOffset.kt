package bin

import ApplicationLogger
import ApplicationSummary
import java.io.RandomAccessFile

class SetBinDataToOffset {
    companion object {
        fun setInt(neededNumber: Number, offset: Int) {
            try {
                val raf = RandomAccessFile(ApplicationSummary.binPath, "rw")

                val ss = ConvertNumToByteArray.convertFromInt(neededNumber)

                raf.seek(offset.toLong())
                raf.write(ss)
                raf.close()

                ApplicationLogger.logger.info("Successfully write data: $neededNumber to $offset!")
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while writing data bytes on $offset")
                AppPrintStackTrace.print(ex)
            }
        }

        fun setFloat(neededNumber: Number, offset: Int) {
            try {
                val raf = RandomAccessFile(ApplicationSummary.binPath, "rw")

                val ss = ConvertNumToByteArray.convertFromFloat(neededNumber)

                raf.seek(offset.toLong())
                raf.write(ss)
                raf.close()

                ApplicationLogger.logger.info("Successfully write data: $neededNumber to $offset!")
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while writing data bytes on $offset")
                AppPrintStackTrace.print(ex)
            }
        }
    }
}