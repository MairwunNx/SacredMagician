package bin

import java.nio.ByteBuffer
import java.nio.ByteOrder

class ConvertNumToByteArray {
    fun convertFromInt(i: Number): ByteArray {
        val bb = ByteBuffer.allocate(Integer.SIZE / java.lang.Byte.SIZE)
        bb.order(ByteOrder.LITTLE_ENDIAN)
        bb.putInt(i.toInt())
        return bb.array()
    }

    fun convertFromFloat(i: Number): ByteArray {
        val bb = ByteBuffer.allocate(Integer.SIZE / java.lang.Byte.SIZE)
        bb.order(ByteOrder.LITTLE_ENDIAN)
        bb.putFloat(i.toFloat())
        return bb.array()
    }
}