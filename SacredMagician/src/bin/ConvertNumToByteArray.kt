package bin

import java.nio.ByteBuffer
import java.nio.ByteOrder

class ConvertNumToByteArray {
    companion object {
        fun convertFromInt(i: Number): ByteArray {
            val byteBuffer = ByteBuffer.allocate(Integer.SIZE / java.lang.Byte.SIZE)
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
            byteBuffer.putInt(i.toInt())
            return byteBuffer.array()
        }

        fun convertFromFloat(i: Number): ByteArray {
            val byteBuffer = ByteBuffer.allocate(Integer.SIZE / java.lang.Byte.SIZE)
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
            byteBuffer.putFloat(i.toFloat())
            return byteBuffer.array()
        }
    }
}