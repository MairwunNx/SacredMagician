package bin

import ApplicationLogger
import ApplicationSummary
import java.io.RandomAccessFile

class SetBinDataToOffset {
    companion object {
        fun setInt(neededNumber: Number, offset: Int) {
            try {
                val randomAccessFile = RandomAccessFile(ApplicationSummary.binPath, "rw")
                val bytes = ConvertNumToByteArray.convertFromInt(neededNumber)

                randomAccessFile.seek(offset.toLong())
                randomAccessFile.write(bytes)
                randomAccessFile.close()

                ApplicationLogger.logger.info("Successfully write data: $neededNumber to $offset!")
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while writing data bytes on $offset")
                AppPrintStackTrace.print(ex)
            }
        }

        fun setFloat(neededNumber: Number, offset: Int) {
            try {
                val randomAccessFile = RandomAccessFile(ApplicationSummary.binPath, "rw")
                val bytes = ConvertNumToByteArray.convertFromFloat(neededNumber)

                randomAccessFile.seek(offset.toLong())
                randomAccessFile.write(bytes)
                randomAccessFile.close()

                ApplicationLogger.logger.info("Successfully write data: $neededNumber to $offset!")
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while writing data bytes on $offset")
                AppPrintStackTrace.print(ex)
            }
        }
    }
}