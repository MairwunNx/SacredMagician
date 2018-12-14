package bin

import ApplicationSummary
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class CreateNewFileDialog {
    companion object {
        fun show() {
            val saveDialog = FileDialog(Frame(), "Select New File Directory", FileDialog.SAVE)

            saveDialog.file = "balance.bin"
            saveDialog.isVisible = true

            if (saveDialog.directory != null || saveDialog.file != null) {
                val filePath = saveDialog.directory + saveDialog.file

                val initialStream = CreateNewFileDialog::class.java.getResourceAsStream("/etc/balance.bin")

                File(filePath).outputStream().use { initialStream.copyTo(it) }

                ApplicationSummary.binPath = filePath

                BaseViewInstance.baseViewInstance.filePathTextField.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileOpened = true

                AddFilePathToRecent.add()

                LoadBalanceBinData.load()
            }
        }
    }
}