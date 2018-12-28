package bin

import ApplicationSummary
import javafx.stage.FileChooser

class OpenExistsFileDialog {
    companion object {
        fun show() {
            val fileChooser = FileChooser()
            val extFilter = FileChooser.ExtensionFilter("Sacred binary files (*.bin)", "*.bin")

            fileChooser.extensionFilters.add(extFilter)
            fileChooser.selectedExtensionFilter = extFilter

            try {
                val file = fileChooser.showOpenDialog(BaseViewInstance.baseViewInstance.root.scene.window)

                ApplicationSummary.binPath = file.path
                BaseViewInstance.baseViewInstance.currentPathLabel.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileOpened = true
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                BaseViewInstance.baseViewInstance.treeView.isDisable = false
                BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
                BaseViewInstance.baseViewInstance.selectFileLabel.isVisible = true

                AddFilePathToRecent.add()
                LoadBalanceBinData.load()
                LoadOpenRecentData.load(true)

                ApplicationSendData.sendUseStat("open-file")
            } catch (ex: Exception) {
                AppPrintStackTrace.print(ex)
            }
        }
    }
}