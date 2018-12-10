package bin

import java.io.InputStream

class ConvertBytesToInt {
    fun convert(inStream: InputStream, offset: Long): Int {
        val b2 = ByteArray(8)

        inStream.skip(offset)
        inStream.read(b2)

        return java.nio.ByteBuffer.wrap(b2).order(java.nio.ByteOrder.LITTLE_ENDIAN).int
    }
}