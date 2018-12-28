package bin

import ApplicationSummary
import javafx.stage.FileChooser
import java.io.File

class SaveAsFileDialog {
    companion object {
        fun open() {
            val fileChooser = FileChooser()
            val extFilter = FileChooser.ExtensionFilter("Sacred binary files (*.bin)", "*.bin")

            fileChooser.extensionFilters.add(extFilter)
            fileChooser.selectedExtensionFilter = extFilter

            try {
                val file = fileChooser.showSaveDialog(BaseViewInstance.baseViewInstance.root.scene.window)

                val initialStream = SaveAsFileDialog::class.java.getResourceAsStream("/etc/balance.bin")

                ApplicationSummary.binPath = file.path
                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                SaveBalanceBinData.save()
                BaseViewInstance.baseViewInstance.currentPathLabel.text = ApplicationSummary.binPath
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false

                ApplicationSendData.sendUseStat("save-as")
            } catch (ex: Exception) {
                AppPrintStackTrace.print(ex)
            }
        }
    }
}