package bin

import ApplicationSummary
import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.stage.FileChooser
import java.io.File

class OverwriteBalanceDialog {
    companion object {
        fun show(dialogType: String) {
            if (BaseViewInstance.baseViewInstance.balanceBinFileOpened) {
                if (BaseViewInstance.baseViewInstance.balanceBinFileChanged) {
                    val alert = Alert(Alert.AlertType.CONFIRMATION)

                    alert.title = "Closing \\ Overwriting Balance File"
                    alert.contentText = "You has changed balance.bin file, you want to save current session file?"

                    val okButton = ButtonType("Yes", ButtonBar.ButtonData.YES)
                    val noButton = ButtonType("No", ButtonBar.ButtonData.NO)
                    val cancelButton = ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE)

                    alert.buttonTypes.setAll(okButton, noButton, cancelButton)

                    alert.showAndWait().ifPresent { type ->
                        if (type == okButton) {
                            val fileChooser = FileChooser()
                            val extFilter = FileChooser.ExtensionFilter("Sacred binary files (*.bin)", "*.bin")

                            fileChooser.extensionFilters.add(extFilter)
                            fileChooser.selectedExtensionFilter = extFilter

                            try {
                                val file = fileChooser.showSaveDialog(BaseViewInstance.baseViewInstance.root.scene.window)
                                ApplicationSummary.binPath = file.path

                                val initialStream = OverwriteBalanceDialog::class.java.getResourceAsStream("/etc/balance.bin")
                                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                                BaseViewInstance.baseViewInstance.balanceBinFileOpened = false

                                SaveBalanceBinData.save()
                                dialogTypesResults(dialogType)
                            } catch (ex: Exception) {
                                AppPrintStackTrace.print(ex)
                            }
                        } else if (type == noButton) dialogTypesResults(dialogType)
                    }
                } else dialogTypesResults(dialogType)
            } else dialogTypesResults(dialogType)
        }

        private fun dialogTypesResults(type: String) {
            if (type == "newFile") CreateNewFileDialog.show()
            if (type == "openFile") OpenExistsFileDialog.show()
            if (type == "appExit") ApplicationShutdown.shutdown()
        }
    }
}