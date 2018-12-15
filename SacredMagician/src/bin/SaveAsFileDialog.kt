package bin

import ApplicationSummary
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class SaveAsFileDialog {
    companion object {
        fun open() {
            val saveDialog = FileDialog(Frame(), "Select Save Directory", FileDialog.SAVE)

            saveDialog.file = "balance.bin"
            saveDialog.isVisible = true

            if (saveDialog.directory != null || saveDialog.file != null) {
                val filePath = saveDialog.directory + saveDialog.file

                val initialStream = SaveAsFileDialog::class.java.getResourceAsStream("/etc/balance.bin")

                ApplicationSummary.binPath = filePath
                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                SaveBalanceBinData.save()
                BaseViewInstance.baseViewInstance.filePathTextField.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
            }
        }
    }
}