package bin

import ApplicationLogger
import ApplicationSummary
import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.stage.FileChooser
import tornadofx.*
import java.io.File
import java.io.PrintWriter

class LoadOpenRecentData {
    companion object {
        fun load(removeOldElements: Boolean = false) {
            if (removeOldElements) {
                try {
                    BaseViewInstance.baseViewInstance.openRecentFileMenu.items.clear()
                } catch (ex: Exception) {
                    AppPrintStackTrace.print(ex)
                }
            }

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
                                    val fileChooser = FileChooser()
                                    val extFilter = FileChooser.ExtensionFilter("Sacred binary files (*.bin)", "*.bin")

                                    fileChooser.extensionFilters.add(extFilter)
                                    fileChooser.selectedExtensionFilter = extFilter

                                    try {
                                        val file = fileChooser.showSaveDialog(BaseViewInstance.baseViewInstance.root.scene.window)
                                        ApplicationSummary.binPath = file.path

                                        val initialStream = LoadOpenRecentData::class.java.getResourceAsStream("/etc/balance.bin")
                                        File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                        BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                                        BaseViewInstance.baseViewInstance.balanceBinFileOpened = false

                                        SaveBalanceBinData.save()
                                        OpenRecentOpenPath.open(i)
                                    } catch (ex: Exception) {
                                        AppPrintStackTrace.print(ex)
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

            if (BaseViewInstance.baseViewInstance.openRecentFileMenu.items.count() != 0) {
                BaseViewInstance.baseViewInstance.openRecentFileMenu.separator()
                BaseViewInstance.baseViewInstance.openRecentFileMenu.item("Remove saved open-recent patches").action {
                    ApplicationLogger.logger.info("Starting removing open recent patches ...")
                    BaseViewInstance.baseViewInstance.openRecentFileMenu.items.clear()
                    PrintWriter("\$SacredMagician\\conf\\app.rcnt.txt").close()
                    ApplicationLogger.logger.info("Removing open recent patches done!")
                }
            }
        }
    }
}