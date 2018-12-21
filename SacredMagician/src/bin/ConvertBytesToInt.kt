package bin

import java.io.InputStream

class ConvertBytesToInt {
    companion object {
        fun convert(inStream: InputStream, offset: Long, isFloat: Boolean): Number {
            val bytes = ByteArray(8)

            inStream.skip(offset)
            inStream.read(bytes)

            if (isFloat) return java.nio.ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).float

            return java.nio.ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).int
        }
    }
}
