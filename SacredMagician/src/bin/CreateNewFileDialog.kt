package bin

import ApplicationSummary
import javafx.stage.FileChooser
import java.io.File

class CreateNewFileDialog {
    companion object {
        fun show() {
            val fileChooser = FileChooser()
            val extFilter = FileChooser.ExtensionFilter("Sacred binary files (*.bin)", "*.bin")

            fileChooser.extensionFilters.add(extFilter)
            fileChooser.selectedExtensionFilter = extFilter

            try {
                val file = fileChooser.showSaveDialog(BaseViewInstance.baseViewInstance.root.scene.window)

                val initialStream = CreateNewFileDialog::class.java.getResourceAsStream("/etc/balance.bin")
                File(file.path).outputStream().use { initialStream.copyTo(it) }

                ApplicationSummary.binPath = file.path
                BaseViewInstance.baseViewInstance.currentPathLabel.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileOpened = true
                BaseViewInstance.baseViewInstance.treeView.isDisable = false
                BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
                BaseViewInstance.baseViewInstance.selectFileLabel.isVisible = true

                AddFilePathToRecent.add()
                LoadBalanceBinData.load()
                LoadOpenRecentData.load(true)

                ApplicationSendData.sendUseStat("new-file")
            } catch (ex: Exception) {
                AppPrintStackTrace.print(ex)
            }
        }
    }
}