package bvw

import ApplicationLogger
import ApplicationSummary
import bin.*
import javafx.fxml.FXML
import javafx.scene.control.Hyperlink
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.TextField
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import tornadofx.*

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
    private val settingsMenuItem: MenuItem by fxid("settingsMenuItem")
    val applicationExitMenuItem: MenuItem by fxid("applicationExitMenuItem")

    val readLicenseMenuItem: MenuItem by fxid("readLicenseMenuItem")
    val readChangeLogMenuItem: MenuItem by fxid("readChangeLogMenuItem")
    val supportMailMenuItem: MenuItem by fxid("supportMailMenuItem")
    val donateMenuItem: MenuItem by fxid("donateMenuItem")
    val openLogMenuItem: MenuItem by fxid("openLogMenuItem")
    val openAppSetgMenuItem: MenuItem by fxid("openAppSetgMenuItem")
    val applicationAboutMenuItem: MenuItem by fxid("applicationAboutMenuItem")

    val filePathTextField: TextField by fxid("filePathTextField")

    private val sourceHyperLink: Hyperlink by fxid("sourceHyperLink")

    init {
        BaseViewInstance.baseViewInstance = this

        LoadOpenRecentData.load()
        subscribeEvent()

        ApplicationLogger.logger.info("Loading SacredMagician done (${(System.currentTimeMillis() - StartTimeCounter.startTime).div(1000.0)} seconds \\ Free: ${Runtime.getRuntime().freeMemory().div(1048576)}MB of ${Runtime.getRuntime().maxMemory().div(1048576)}MB)!")
    }

    @FXML @Suppress("unused")
    private fun handleChangesBalanceBin(e: KeyEvent) {
        val s = e.source as TextField

        s.textProperty().addListener { _, oldValue, newValue ->
            if (!newValue.matches("\\d*".toRegex())) s.text = newValue.replace("[^\\d.]".toRegex(), "")

            if (newValue.length > 5) s.text = oldValue
        }

        if (ApplicationSummary.binPath != "") balanceBinFileChanged = true
    }

    private fun subscribeEvent() {
        sourceHyperLink.action {
            OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
        }

        settingsMenuItem.action {
            openInternalWindow<SettingsView>(movable = false)
        }

        MenuItemSubscribeEvents.subscribe()
    }
}

