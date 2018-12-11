package bin

import java.io.InputStream

class ConvertBytesToInt {
    companion object {
        fun convert(inStream: InputStream, offset: Long, isFloat: Boolean): Number {
            val b2 = ByteArray(8)

            inStream.skip(offset)
            inStream.read(b2)

            if (isFloat) {
                return java.nio.ByteBuffer.wrap(b2).order(java.nio.ByteOrder.LITTLE_ENDIAN).float
            }

            return java.nio.ByteBuffer.wrap(b2).order(java.nio.ByteOrder.LITTLE_ENDIAN).int
        }
    }
}
