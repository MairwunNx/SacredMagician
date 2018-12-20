package bin

import javafx.application.Platform
import java.util.*

class RunMemoryCounting {
    companion object {
        fun start() {
            val timer = Timer()
            timer.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    Platform.runLater {
                        val usedMemory = (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()).div(1048576)
                        BaseViewInstance.baseViewInstance.freeApplicationRamLabel.text = "${usedMemory}MB"
                    }
                }
            }, 0, 1000)
        }
    }
}