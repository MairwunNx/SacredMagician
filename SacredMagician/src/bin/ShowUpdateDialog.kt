package bin

import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import java.awt.Desktop
import java.io.File

class ShowUpdateDialog {
    companion object {
        fun showDialog() {
            val alert = Alert(Alert.AlertType.CONFIRMATION)

            alert.title = "SacredMagician Updater"
            alert.headerText = ""
            alert.contentText = "New update available now! Want you update to new version?"

            val okButton = ButtonType("Yes", ButtonBar.ButtonData.YES)
            val noButton = ButtonType("No", ButtonBar.ButtonData.NO)

            alert.buttonTypes.setAll(okButton, noButton)

            alert.showAndWait().ifPresent { type ->
                if (type == okButton) {
                    Desktop.getDesktop().open(File("updater.jar"))

                    ApplicationShutdown.shutdown()
                }
            }
        }
    }
}