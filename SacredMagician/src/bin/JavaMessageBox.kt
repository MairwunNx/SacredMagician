package bin

import javafx.scene.control.Alert
import javafx.scene.image.Image
import javafx.stage.Stage

class JavaMessageBox {
    companion object {
        fun show(message: String, type: String = "INFORMATION") {
            val alert = Alert(Alert.AlertType.valueOf(type))

            alert.headerText = ""
            (alert.dialogPane.scene.window as Stage).icons.add(Image("/ico/SacredMagician.png"))
            alert.title = "SacredMagician ${type.toLowerCase()}"
            alert.contentText = message
            alert.show()
        }
    }
}