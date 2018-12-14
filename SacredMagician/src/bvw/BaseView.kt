package bvw

import ApplicationLogger
import ApplicationSummary
import bin.*
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import tornadofx.*
import java.awt.Desktop
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class BaseView : View("${ApplicationSummary.name} ${ApplicationSummary.aVersion}") {
    override val root: BorderPane by fxml("/wnd/BaseWindow.fxml")

     var balanceBinFileOpened: Boolean = false
     var balanceBinFileChanged: Boolean = false

     val bronzeAwVwTextField: TextField by fxid("bronzeAwVwTextField")
     val bronzeHitPointsTextField: TextField by fxid("bronzeHitPointsTextField")
     val bronzeResistanceTextField: TextField by fxid("bronzeResistanceTextField")
     val bronzeDamageTextField: TextField by fxid("bronzeDamageTextField")

     val silverAwVwTextField: TextField by fxid("silverAwVwTextField")
     val silverHitPointsTextField: TextField by fxid("silverHitPointsTextField")
     val silverResistanceTextField: TextField by fxid("silverResistanceTextField")
     val silverDamageTextField: TextField by fxid("silverDamageTextField")

     val goldAwVwTextField: TextField by fxid("goldAwVwTextField")
     val goldHitPointsTextField: TextField by fxid("goldHitPointsTextField")
     val goldResistanceTextField: TextField by fxid("goldResistanceTextField")
     val goldDamageTextField: TextField by fxid("goldDamageTextField")

     val platinumAwVwTextField: TextField by fxid("platinumAwVwTextField")
     val platinumHitPointsTextField: TextField by fxid("platinumHitPointsTextField")
     val platinumResistanceTextField: TextField by fxid("platinumResistanceTextField")
     val platinumDamageTextField: TextField by fxid("platinumDamageTextField")

     val niobiumAwVwTextField: TextField by fxid("niobiumAwVwTextField")
     val niobiumHitPointsTextField: TextField by fxid("niobiumHitPointsTextField")
     val niobiumResistanceTextField: TextField by fxid("niobiumResistanceTextField")
     val niobiumDamageTextField: TextField by fxid("niobiumDamageTextField")

     val multiPlayerAwVwTextField: TextField by fxid("multiPlayerAwVwTextField")
     val multiPlayerHitPointsTextField: TextField by fxid("multiPlayerHitPointsTextField")
     val multiPlayerResistanceTextField: TextField by fxid("multiPlayerResistanceTextField")
     val multiPlayerDamageTextField: TextField by fxid("multiPlayerDamageTextField")

     val southCenterRegionTextField: TextField by fxid("southCenterRegionTextField")
     val northCenterRegionTextField: TextField by fxid("northCenterRegionTextField")
     val swampBaseRegionTextField: TextField by fxid("swampBaseRegionTextField")
     val westBaseRegionTextField: TextField by fxid("westBaseRegionTextField")
     val northBaseRegionTextField: TextField by fxid("northBaseRegionTextField")
     val lavaBaseRegionTextField: TextField by fxid("lavaBaseRegionTextField")
     val shaddarBaseRegionTextField: TextField by fxid("shaddarBaseRegionTextField")
     val upperUnderworldTextField: TextField by fxid("upperUnderworldTextField")
     val lowerBaseRegionTextField: TextField by fxid("lowerBaseRegionTextField")

     val newFileMenuItem: MenuItem by fxid("newFileMenuItem")
     val openFileMenuItem: MenuItem by fxid("openFileMenuItem")
     val openRecentFileMenu: Menu by fxid("openRecentFileMenu")
     val saveFileMenu: MenuItem by fxid("saveFileMenu")
     val saveAsFileMenu: MenuItem by fxid("saveAsFileMenu")
     val settingsMenuItem: MenuItem by fxid("settingsMenuItem")
     val applicationExitMenuItem: MenuItem by fxid("applicationExitMenuItem")

     val readLicenseMenuItem: MenuItem by fxid("readLicenseMenuItem")
     val readChangeLogMenuItem: MenuItem by fxid("readChangeLogMenuItem")
     val supportMailMenuItem: MenuItem by fxid("supportMailMenuItem")
     val donateMenuItem: MenuItem by fxid("donateMenuItem")
     val openLogMenuItem: MenuItem by fxid("openLogMenuItem")
     val openAppSetgMenuItem: MenuItem by fxid("openAppSetgMenuItem")
     val applicationAboutMenuItem: MenuItem by fxid("applicationAboutMenuItem")

     val filePathTextField: TextField by fxid("filePathTextField")

     val sourceHyperLink: Hyperlink by fxid("sourceHyperLink")

    init {
        loadOpenRecentData()
        subscribeEvent()
    }

    private fun loadOpenRecentData() {
        ReadOpenRecentFile.read().forEach { i ->
            openRecentFileMenu.item(i).action {
                if (balanceBinFileOpened) {
                    if (balanceBinFileChanged) {
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

                                    val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

                                    ApplicationSummary.binPath = filePath

                                    File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                    balanceBinFileChanged = false
                                    balanceBinFileOpened = false

                                    SaveBalanceBinData.save()

                                    ApplicationSummary.binPath = i
                                    filePathTextField.text = ApplicationSummary.binPath

                                    balanceBinFileOpened = true
                                    balanceBinFileChanged = false

                                    LoadBalanceBinData.load()
                                }
                            }

                            if (type == noButton) {
                                ApplicationSummary.binPath = i
                                filePathTextField.text = ApplicationSummary.binPath
                                balanceBinFileOpened = true
                                balanceBinFileChanged = false

                                LoadBalanceBinData.load()
                            }
                        }
                    } else {
                        ApplicationSummary.binPath = i
                        filePathTextField.text = ApplicationSummary.binPath
                        balanceBinFileOpened = true
                        balanceBinFileChanged = false

                        LoadBalanceBinData.load()
                    }
                }
                else {
                    ApplicationSummary.binPath = i
                    filePathTextField.text = ApplicationSummary.binPath
                    balanceBinFileOpened = true
                    balanceBinFileChanged = false

                    LoadBalanceBinData.load()
                }

                ApplicationLogger.logger.info("File path: $i opened by user in Open Recent")
            }

            ApplicationLogger.logger.info("Successfully loaded path: $i")
        }
    }

    @FXML @Suppress("unused")
    private fun handleChangesBalanceBin(e: KeyEvent) {
        val s = e.source as TextField

        s.textProperty().addListener { _, oldValue, newValue ->
            if (!newValue.matches("\\d*".toRegex())) {
                s.text = newValue.replace("[^\\d.]".toRegex(), "")
            }

            if (newValue.length > 5) {
                s.text = oldValue
            }
        }

        if (ApplicationSummary.binPath != "") balanceBinFileChanged = true
    }

    private fun subscribeEvent() {
        newFileMenuItem.action {
            if (balanceBinFileOpened) {
                if (balanceBinFileChanged) {
                    val alert = Alert(Alert.AlertType.CONFIRMATION)

                    alert.title = "Overwriting Balance File"
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

                                val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

                                ApplicationSummary.binPath = filePath

                                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                balanceBinFileChanged = false
                                balanceBinFileOpened = false

                                SaveBalanceBinData.save()

                                CreateNewFileDialog.show()
                            }
                        }

                        if (type == noButton) CreateNewFileDialog.show()
                    }
                } else CreateNewFileDialog.show()
            } else CreateNewFileDialog.show()
        }

        openFileMenuItem.action {
            if (balanceBinFileOpened) {
                if (balanceBinFileChanged) {
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

                                val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

                                ApplicationSummary.binPath = filePath

                                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                balanceBinFileChanged = false
                                balanceBinFileOpened = false

                                SaveBalanceBinData.save()

                                OpenExistsFileDialog.show()
                            }
                        }

                        if (type == noButton) OpenExistsFileDialog.show()
                    }
                } else OpenExistsFileDialog.show()
            } else OpenExistsFileDialog.show()
        }

        saveFileMenu.action {
            SaveBalanceBinData.save()

            balanceBinFileChanged = false
        }

        saveAsFileMenu.action {
            val saveDialog = FileDialog(Frame(), "Select Save Directory", FileDialog.SAVE)

            saveDialog.file = "balance.bin"
            saveDialog.isVisible = true

            if (saveDialog.directory != null || saveDialog.file != null) {
                val filePath = saveDialog.directory + saveDialog.file

                val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

                ApplicationSummary.binPath = filePath

                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                SaveBalanceBinData.save()

                filePathTextField.text = ApplicationSummary.binPath
                balanceBinFileChanged = false
            }
        }

        applicationExitMenuItem.action {
            if (balanceBinFileOpened) {
                if (balanceBinFileChanged) {
                    val alert = Alert(Alert.AlertType.CONFIRMATION)

                    alert.title = "Application Closing"
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

                                val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

                                ApplicationSummary.binPath = filePath

                                File(ApplicationSummary.binPath).outputStream().use { initialStream.copyTo(it) }

                                balanceBinFileChanged = false
                                balanceBinFileOpened = false

                                SaveBalanceBinData.save()

                                ApplicationShutdown.shutdown()
                            }
                        }

                        if (type == noButton) ApplicationShutdown.shutdown()
                    }
                } else ApplicationShutdown.shutdown()
            } else ApplicationShutdown.shutdown()
        }

        applicationAboutMenuItem.action {
            val alert = Alert(Alert.AlertType.INFORMATION)

            alert.headerText = ""
            alert.title = "About SacredMagician"
            alert.contentText = "SacredMagician Release Version: ${ApplicationSummary.version}\nSacredMagician Alpha Version: ${ApplicationSummary.aVersion}\nSacredMagician Version Type: ${ApplicationSummary.type}\nSacredMagician Build: ${ApplicationSummary.build}\n\nThanks for using SacredMagician Balance editor!\n\nAuthor: MairwunNx, Licensed Under Apache 2.0"
            alert.show()
        }

        sourceHyperLink.action {
            OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
        }

        readLicenseMenuItem.action {
            OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
        }

        readChangeLogMenuItem.action {
            OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/CHANGELOG.md")
        }

        supportMailMenuItem.action {
            OpenBrowserLink.open("mailto://MairwunNx@gmail.com")
        }

        donateMenuItem.action {
            OpenBrowserLink.open("https://money.yandex.ru/to/410015993365458")
        }

        openLogMenuItem.action {
            Desktop.getDesktop().open(File("\$SacredMagician\\logs\\latest.log"))
        }

        openAppSetgMenuItem.action {
            Desktop.getDesktop().open(File("\$SacredMagician\\conf\\app.setg.toml"))
        }

        settingsMenuItem.action {
            openInternalWindow<SettingsView>(movable = false)
        }
    }
}

