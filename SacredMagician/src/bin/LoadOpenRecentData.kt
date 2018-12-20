package bin

import ApplicationLogger
import ApplicationSummary
import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import tornadofx.*
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class LoadOpenRecentData {
    companion object {
        fun load() {
            ReadOpenRecentFile.read().forEach { i ->
                BaseViewInstance.baseViewInstance.openRecentFileMenu.item(i).action {
                    if (BaseViewInstance.baseViewInstance.balanceBinFileOpened) {
                        if (BaseViewInstance.baseViewInstance.balanceBinFileChanged) {
                            val alert = Alert(Alert.AlertType.CONFIRMATION)

                            alert.title = "Closing Current Balance File"
                            alert.contentText = "You has changed balance.bin file, you want to save current session file?"

                            val okButton = ButtonType("Yes", ButtonBar.ButtonData.YES)
                            val noButton = ButtonType("No", ButtonBar.ButtonData.NO)
                            val cancelButton = ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE)

                            alert.buttonTypes.setAll(okButton, noButton, cancelButton)

                            alert.showAndWait().ifPresent { type ->
                                if (type == okButton) {
                                    val saveDialog = FileDialog(Frame(), "Select Save Directory", FileDialog.SAVE)

                                    saveDialog.file = "balance.bin"
                                    saveDialog.isVisible = true

                                    if (saveDialog.directory != null || saveDialog.file != null) {
                                        val filePath = saveDialog.directory + saveDialog.file

                                        val initialStream = LoadOpenRecentData::class.java.getResourceAsStream("/etc/balance.bin")

                                        ApplicationSummary.binPath = filePath

                                        File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                        BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                                        BaseViewInstance.baseViewInstance.balanceBinFileOpened = false

                                        SaveBalanceBinData.save()
                                        OpenRecentOpenPath.open(i)
                                    }
                                } else if (type == noButton) OpenRecentOpenPath.open(i)
                            }
                        } else OpenRecentOpenPath.open(i)
                    } else OpenRecentOpenPath.open(i)

                    BaseViewInstance.baseViewInstance.treeView.isDisable = false
                    BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
                    BaseViewInstance.baseViewInstance.selectFileLabel.isVisible = true
                }

                ApplicationLogger.logger.info("Successfully loaded path: $i")
            }
        }
    }
}