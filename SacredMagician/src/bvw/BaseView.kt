package bvw

import ApplicationLogger
import ApplicationSummary
import bin.GetBinDataByOffset
import bin.ReadOpenRecentFile
import bin.SetBinDataToOffset
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import tornadofx.*
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class BaseView : View("${ApplicationSummary().name} ${ApplicationSummary().aVersion}") {
    override val root: BorderPane by fxml("/wnd/BaseWindow.fxml")

    private var balanceBinFileOpened: Boolean = false
    private var balanceBinFileChanged = false

    private val bronzeAwVwTextField: TextField by fxid("bronzeAwVwTextField")
    private val bronzeHitPointsTextField: TextField by fxid("bronzeHitPointsTextField")
    private val bronzeResistanceTextField: TextField by fxid("bronzeResistanceTextField")
    private val bronzeDamageTextField: TextField by fxid("bronzeDamageTextField")

    private val silverAwVwTextField: TextField by fxid("silverAwVwTextField")
    private val silverHitPointsTextField: TextField by fxid("silverHitPointsTextField")
    private val silverResistanceTextField: TextField by fxid("silverResistanceTextField")
    private val silverDamageTextField: TextField by fxid("silverDamageTextField")

    private val goldAwVwTextField: TextField by fxid("goldAwVwTextField")
    private val goldHitPointsTextField: TextField by fxid("goldHitPointsTextField")
    private val goldResistanceTextField: TextField by fxid("goldResistanceTextField")
    private val goldDamageTextField: TextField by fxid("goldDamageTextField")

    private val platinumAwVwTextField: TextField by fxid("platinumAwVwTextField")
    private val platinumHitPointsTextField: TextField by fxid("platinumHitPointsTextField")
    private val platinumResistanceTextField: TextField by fxid("platinumResistanceTextField")
    private val platinumDamageTextField: TextField by fxid("platinumDamageTextField")

    private val niobiumAwVwTextField: TextField by fxid("niobiumAwVwTextField")
    private val niobiumHitPointsTextField: TextField by fxid("niobiumHitPointsTextField")
    private val niobiumResistanceTextField: TextField by fxid("niobiumResistanceTextField")
    private val niobiumDamageTextField: TextField by fxid("niobiumDamageTextField")

    private val multiPlayerAwVwTextField: TextField by fxid("multiPlayerAwVwTextField")
    private val multiPlayerHitPointsTextField: TextField by fxid("multiPlayerHitPointsTextField")
    private val multiPlayerResistanceTextField: TextField by fxid("multiPlayerResistanceTextField")
    private val multiPlayerDamageTextField: TextField by fxid("multiPlayerDamageTextField")

    private val southCenterRegionTextField: TextField by fxid("southCenterRegionTextField")
    private val northCenterRegionTextField: TextField by fxid("northCenterRegionTextField")
    private val swampBaseRegionTextField: TextField by fxid("swampBaseRegionTextField")
    private val westBaseRegionTextField: TextField by fxid("westBaseRegionTextField")
    private val northBaseRegionTextField: TextField by fxid("northBaseRegionTextField")
    private val lavaBaseRegionTextField: TextField by fxid("lavaBaseRegionTextField")
    private val shaddarBaseRegionTextField: TextField by fxid("shaddarBaseRegionTextField")
    private val upperUnderworldTextField: TextField by fxid("upperUnderworldTextField")
    private val lowerBaseRegionTextField: TextField by fxid("lowerBaseRegionTextField")

    private val newFileMenuItem: MenuItem by fxid("newFileMenuItem")
    private val openFileMenuItem: MenuItem by fxid("openFileMenuItem")
    private val openRecentFileMenu: Menu by fxid("openRecentFileMenu")
    private val saveFileMenu: MenuItem by fxid("saveFileMenu")

    private val filePathTextField: TextField by fxid("filePathTextField")

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

                                    saveDataToBalanceBin()

                                    ApplicationSummary.binPath = i
                                    filePathTextField.text = ApplicationSummary.binPath

                                    balanceBinFileOpened = true
                                    balanceBinFileChanged = false

                                    loadBalanceData()
                                }
                            }

                            if (type == noButton) {
                                ApplicationSummary.binPath = i
                                filePathTextField.text = ApplicationSummary.binPath
                                balanceBinFileOpened = true
                                balanceBinFileChanged = false

                                loadBalanceData()
                            }
                        }
                    } else {
                        ApplicationSummary.binPath = i
                        filePathTextField.text = ApplicationSummary.binPath
                        balanceBinFileOpened = true
                        balanceBinFileChanged = false

                        loadBalanceData()
                    }
                }
                else {
                    ApplicationSummary.binPath = i
                    filePathTextField.text = ApplicationSummary.binPath
                    balanceBinFileOpened = true
                    balanceBinFileChanged = false

                    loadBalanceData()
                }
            }

            ApplicationLogger.logger.info("Successfully loaded path: $i")
        }
    }

    @FXML @Suppress("unused")
    private fun handleChangesBalanceBin() {
        if (filePathTextField.text != "") {
            balanceBinFileChanged = true
        }
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

                                saveDataToBalanceBin()

                                openCreateNewFileDialog()
                            }
                        }

                        if (type == noButton) openCreateNewFileDialog()
                    }
                } else openCreateNewFileDialog()
            } else openCreateNewFileDialog()
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

                                saveDataToBalanceBin()

                                openFileDialog()
                            }
                        }

                        if (type == noButton) openFileDialog()
                    }
                } else openFileDialog()
            } else openFileDialog()
        }

        saveFileMenu.action(this::saveDataToBalanceBin)
    }

    private fun openFileDialog() {
        val openDialog = FileDialog(Frame(), "Select Open File Directory", FileDialog.LOAD)

        openDialog.file = "*.bin"
        openDialog.isVisible = true

        if (openDialog.directory != null || openDialog.file != null) {
            val filePath = openDialog.directory + openDialog.file

            ApplicationSummary.binPath = filePath
            filePathTextField.text = ApplicationSummary.binPath
            balanceBinFileOpened = true
            balanceBinFileChanged = false

            val file = File("\$SacredMagician\\conf\\app.rcnt.txt")
            val fileText = file.readText()

            if (!fileText.contains(ApplicationSummary.binPath, true)) {
                file.appendText(ApplicationSummary.binPath + System.getProperty("line.separator"))
            }

            loadBalanceData()
        }
    }

    private fun openCreateNewFileDialog() {
        val saveDialog = FileDialog(Frame(), "Select New File Directory", FileDialog.SAVE)

        saveDialog.file = "balance.bin"
        saveDialog.isVisible = true

        if (saveDialog.directory != null || saveDialog.file != null) {
            val filePath = saveDialog.directory + saveDialog.file

            val initialStream = javaClass.getResourceAsStream("/etc/balance.bin")

            File(filePath).outputStream().use { initialStream.copyTo(it) }

            ApplicationSummary.binPath = filePath

            filePathTextField.text = ApplicationSummary.binPath
            balanceBinFileOpened = true

            val file = File("\$SacredMagician\\conf\\app.rcnt.txt")
            val fileText = file.readText()

            if (!fileText.contains(ApplicationSummary.binPath, true)) {
                file.appendText(ApplicationSummary.binPath + System.getProperty("line.separator"))
            }

            loadBalanceData()
        }
    }

    private fun loadBalanceData() {
        southCenterRegionTextField.text = GetBinDataByOffset.get(22392, false).toString()
        northCenterRegionTextField.text = GetBinDataByOffset.get(22456, false).toString()
        swampBaseRegionTextField.text = GetBinDataByOffset.get(22520, false).toString()
        westBaseRegionTextField.text = GetBinDataByOffset.get(22584, false).toString()
        northBaseRegionTextField.text = GetBinDataByOffset.get(22648, false).toString()
        lavaBaseRegionTextField.text = GetBinDataByOffset.get(22712, false).toString()
        shaddarBaseRegionTextField.text = GetBinDataByOffset.get(22776, false).toString()
        upperUnderworldTextField.text = GetBinDataByOffset.get(22840, false).toString()
        lowerBaseRegionTextField.text = GetBinDataByOffset.get(22904, false).toString()

        bronzeAwVwTextField.text = GetBinDataByOffset.get(1832, true).toString()
        bronzeHitPointsTextField.text = GetBinDataByOffset.get(1856, true).toString()
        bronzeResistanceTextField.text = GetBinDataByOffset.get(1904, true).toString()
        bronzeDamageTextField.text = GetBinDataByOffset.get(1880, true).toString()

        silverAwVwTextField.text = GetBinDataByOffset.get(1812, true).toString()
        silverHitPointsTextField.text = GetBinDataByOffset.get(1836, true).toString()
        silverResistanceTextField.text = GetBinDataByOffset.get(1884, true).toString()
        silverDamageTextField.text = GetBinDataByOffset.get(1860, true).toString()

        goldAwVwTextField.text = GetBinDataByOffset.get(1816, true).toString()
        goldHitPointsTextField.text = GetBinDataByOffset.get(1840, true).toString()
        goldResistanceTextField.text = GetBinDataByOffset.get(1888, true).toString()
        goldDamageTextField.text = GetBinDataByOffset.get(1864, true).toString()

        platinumAwVwTextField.text = GetBinDataByOffset.get(1820, true).toString()
        platinumHitPointsTextField.text = GetBinDataByOffset.get(1844, true).toString()
        platinumResistanceTextField.text = GetBinDataByOffset.get(1892, true).toString()
        platinumDamageTextField.text = GetBinDataByOffset.get(1868, true).toString()

        niobiumAwVwTextField.text = GetBinDataByOffset.get(1824, true).toString()
        niobiumHitPointsTextField.text = GetBinDataByOffset.get(1848, true).toString()
        niobiumResistanceTextField.text = GetBinDataByOffset.get(1896, true).toString()
        niobiumDamageTextField.text = GetBinDataByOffset.get(1872, true).toString()

        multiPlayerAwVwTextField.text = GetBinDataByOffset.get(1828, true).toString()
        multiPlayerHitPointsTextField.text = GetBinDataByOffset.get(1852, true).toString()
        multiPlayerResistanceTextField.text = GetBinDataByOffset.get(1900, true).toString()
        multiPlayerDamageTextField.text = GetBinDataByOffset.get(1876, true).toString()
    }

    private fun saveDataToBalanceBin() {
        SetBinDataToOffset.setInt(southCenterRegionTextField.text.toInt(), 22392)
        SetBinDataToOffset.setInt(northCenterRegionTextField.text.toInt(), 22456)
        SetBinDataToOffset.setInt(swampBaseRegionTextField.text.toInt(), 22520)
        SetBinDataToOffset.setInt(westBaseRegionTextField.text.toInt(), 22584)
        SetBinDataToOffset.setInt(northBaseRegionTextField.text.toInt(), 22648)
        SetBinDataToOffset.setInt(lavaBaseRegionTextField.text.toInt(), 22712)
        SetBinDataToOffset.setInt(shaddarBaseRegionTextField.text.toInt(), 22776)
        SetBinDataToOffset.setInt(upperUnderworldTextField.text.toInt(), 22840)
        SetBinDataToOffset.setInt(lowerBaseRegionTextField.text.toInt(), 22904)

        SetBinDataToOffset.setFloat(bronzeAwVwTextField.text.toFloat(), 1832)
        SetBinDataToOffset.setFloat(bronzeHitPointsTextField.text.toFloat(), 1856)
        SetBinDataToOffset.setFloat(bronzeResistanceTextField.text.toFloat(), 1904)
        SetBinDataToOffset.setFloat(bronzeDamageTextField.text.toFloat(), 1880)

        SetBinDataToOffset.setFloat(silverAwVwTextField.text.toFloat(), 1812)
        SetBinDataToOffset.setFloat(silverHitPointsTextField.text.toFloat(), 1836)
        SetBinDataToOffset.setFloat(silverResistanceTextField.text.toFloat(), 1884)
        SetBinDataToOffset.setFloat(silverDamageTextField.text.toFloat(), 1860)

        SetBinDataToOffset.setFloat(goldAwVwTextField.text.toFloat(), 1816)
        SetBinDataToOffset.setFloat(goldHitPointsTextField.text.toFloat(), 1840)
        SetBinDataToOffset.setFloat(goldResistanceTextField.text.toFloat(), 1888)
        SetBinDataToOffset.setFloat(goldDamageTextField.text.toFloat(), 1864)

        SetBinDataToOffset.setFloat(platinumAwVwTextField.text.toFloat(), 1820)
        SetBinDataToOffset.setFloat(platinumHitPointsTextField.text.toFloat(), 1844)
        SetBinDataToOffset.setFloat(platinumResistanceTextField.text.toFloat(), 1892)
        SetBinDataToOffset.setFloat(platinumDamageTextField.text.toFloat(), 1868)

        SetBinDataToOffset.setFloat(niobiumAwVwTextField.text.toFloat(), 1824)
        SetBinDataToOffset.setFloat(niobiumHitPointsTextField.text.toFloat(), 1848)
        SetBinDataToOffset.setFloat(niobiumResistanceTextField.text.toFloat(), 1896)
        SetBinDataToOffset.setFloat(niobiumDamageTextField.text.toFloat(), 1872)

        SetBinDataToOffset.setFloat(multiPlayerAwVwTextField.text.toFloat(), 1828)
        SetBinDataToOffset.setFloat(multiPlayerHitPointsTextField.text.toFloat(), 1852)
        SetBinDataToOffset.setFloat(multiPlayerResistanceTextField.text.toFloat(), 1900)
        SetBinDataToOffset.setFloat(multiPlayerDamageTextField.text.toFloat(), 1876)

        ApplicationLogger.logger.info("Balance.bin changes successfully saved to origin!")
    }
}

