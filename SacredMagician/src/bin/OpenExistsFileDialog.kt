package bin

import ApplicationSummary
import java.awt.FileDialog
import java.awt.Frame

class OpenExistsFileDialog {
    companion object {
        fun show() {
            val openDialog = FileDialog(Frame(), "Select Open File Directory", FileDialog.LOAD)

            openDialog.file = "*.bin"
            openDialog.isVisible = true

            if (openDialog.directory != null || openDialog.file != null) {
                val filePath = openDialog.directory + openDialog.file

                ApplicationSummary.binPath = filePath
                BaseViewInstance.baseViewInstance.filePathTextField.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileOpened = true
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false

                AddFilePathToRecent.add()
                LoadBalanceBinData.load()
            }
        }
    }
}