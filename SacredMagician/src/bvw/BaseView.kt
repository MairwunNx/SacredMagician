package bvw

import ApplicationLogger
import ApplicationSummary
import bin.*
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import tornadofx.*

class BaseView : View(ApplicationSummary.name) {
    override val root: BorderPane by fxml("/wnd/BaseWindow.fxml")

    var xOffset: Double = 0.0
    var yOffset: Double = 0.0
    var balanceBinFileOpened: Boolean = false
    var balanceBinFileChanged: Boolean = false

    //region BaseView Window Controls

    val treeView: TreeView<String> by fxid("baseTreeView")
    var rootTreeNode = TreeItem("Root")
    var tooltip: Tooltip = Tooltip("Path unavailable, balance.bin file not created or not opened.")

    val balanceSettings = TreeItem<String>("Balance")
    val skillsSettings = TreeItem<String>("Player-Skills")
    val regionsQtySettings = TreeItem<String>("Regions-Qty")
    val applicationSettings = TreeItem<String>("Application")
    val updateNowItem = TreeItem<String>("Update Now!")

    val notSelectedPanel: Pane by fxid("notSelectedPane")
    val bronzeSettingsPanel: Pane by fxid("bronzeSettingsPanel")
    val silverSettingsPanel: Pane by fxid("silverSettingsPanel")
    val goldenSettingsPanel: Pane by fxid("goldenSettingsPanel")
    val platinumSettingsPanel: Pane by fxid("platinumSettingsPanel")
    val niobiumSettingsPanel: Pane by fxid("niobiumSettingsPanel")
    val serverSettingsPanel: Pane by fxid("serverSettingsPanel")
    val skillsSettingsPanel: Pane by fxid("skillsSettingsPanel")
    val regionQtySettingsPanel: Pane by fxid("regionQtySettingsPanel")
    val applicationSettingsPanel: Pane by fxid("applicationSettingsPanel")

    val aboutPane: Pane by fxid("aboutPane")
    val closeDialogButtonRect: Rectangle by fxid("closeDialogButtonRect")
    val closeDialogButtonSvg: SVGPath by fxid("closeDialogButtonSvg")
    val aboutDialogBackground: Rectangle by fxid("aboutDialogBackground")

    val licenseAgreementPane: Pane by fxid("licenseAgreementPane")
    val readLicenseButton: Button by fxid("readLicenseButton")
    val closeAppButton: Button by fxid("closeAppButton")
    val acceptAgreementsButton: Button by fxid("acceptAgreementsButton")

    val closeButtonRect: Rectangle by fxid("closeButtonRect")
    val closeButtonSvg: SVGPath by fxid("closeButtonSvg")
    val applicationHeaderRect: Rectangle by fxid("applicationHeaderRect")
    val freeApplicationRamLabel: Label by fxid("freeApplicationRamLabel")
    val gitHubButtonRect: Rectangle by fxid("gitHubButtonRect")
    val gitHubButtonSvg: SVGPath by fxid("gitHubButtonSvg")
    val openOrCreateLabel: Label by fxid("openOrCreateLabel")
    val selectFileLabel: Label by fxid("selectFileLabel")

    val bronzeAwVwTextField: TextField by fxid("bronzeAwVwTextField")
    val bronzeHitPointsTextField: TextField by fxid("bronzeHitPointsTextField")
    val bronzeResistanceTextField: TextField by fxid("bronzeResistanceTextField")
    val bronzeDamageTextField: TextField by fxid("bronzeDamageTextField")
    val bronzeExperienceTextField: TextField by fxid("bronzeExperienceTextField")

    val silverAwVwTextField: TextField by fxid("silverAwVwTextField")
    val silverHitPointsTextField: TextField by fxid("silverHitPointsTextField")
    val silverResistanceTextField: TextField by fxid("silverResistanceTextField")
    val silverDamageTextField: TextField by fxid("silverDamageTextField")
    val silverExperienceTextField: TextField by fxid("silverExperienceTextField")
    val silverMinLevelTextField: TextField by fxid("silverMinLevelTextField")

    val goldenAwVwTextField: TextField by fxid("goldenAwVwTextField")
    val goldenHitPointsTextField: TextField by fxid("goldenHitPointsTextField")
    val goldenResistanceTextField: TextField by fxid("goldenResistanceTextField")
    val goldenDamageTextField: TextField by fxid("goldenDamageTextField")
    val goldenExperienceTextField: TextField by fxid("goldenExperienceTextField")
    val goldenMinLevelTextField: TextField by fxid("goldenMinLevelTextField")

    val platinumAwVwTextField: TextField by fxid("platinumAwVwTextField")
    val platinumHitPointsTextField: TextField by fxid("platinumHitPointsTextField")
    val platinumResistanceTextField: TextField by fxid("platinumResistanceTextField")
    val platinumDamageTextField: TextField by fxid("platinumDamageTextField")
    val platinumExperienceTextField: TextField by fxid("platinumExperienceTextField")
    val platinumMinLevelTextField: TextField by fxid("platinumMinLevelTextField")
    val platinumMaxLevelTextField: TextField by fxid("platinumMaxLevelTextField")

    val niobiumAwVwTextField: TextField by fxid("niobiumAwVwTextField")
    val niobiumHitPointsTextField: TextField by fxid("niobiumHitPointsTextField")
    val niobiumResistanceTextField: TextField by fxid("niobiumResistanceTextField")
    val niobiumDamageTextField: TextField by fxid("niobiumDamageTextField")
    val niobiumExperienceTextField: TextField by fxid("niobiumExperienceTextField")
    val niobiumMinLevelTextField: TextField by fxid("niobiumMinLevelTextField")

    val globalAwVwTextField: TextField by fxid("globalAwVwTextField")
    val globalHitPointsTextField: TextField by fxid("globalHitPointsTextField")
    val globalResistanceTextField: TextField by fxid("globalResistanceTextField")
    val globalDamageTextField: TextField by fxid("globalDamageTextField")
    val serverExperienceTextField: TextField by fxid("serverExperienceTextField")

    val southCenterRegionTextField: TextField by fxid("southCenterRegionTextField")
    val northCenterRegionTextField: TextField by fxid("northCenterRegionTextField")
    val swampBaseRegionTextField: TextField by fxid("swampBaseRegionTextField")
    val westBaseRegionTextField: TextField by fxid("westBaseRegionTextField")
    val northBaseRegionTextField: TextField by fxid("northBaseRegionTextField")
    val lavaBaseRegionTextField: TextField by fxid("lavaBaseRegionTextField")
    val shaddarBaseRegionTextField: TextField by fxid("shaddarBaseRegionTextField")
    val upperUnderworldTextField: TextField by fxid("upperUnderworldTextField")
    val lowerBaseRegionTextField: TextField by fxid("lowerBaseRegionTextField")

    val firstSkillTextField: TextField by fxid("firstSkillTextField")
    val secondSkillTextField: TextField by fxid("secondSkillTextField")
    val thirdSkillTextField: TextField by fxid("thirdSkillTextField")
    val fourthSkillTextField: TextField by fxid("fourthSkillTextField")
    val fifthSkillTextField: TextField by fxid("fifthSkillTextField")
    val sixthSkillTextField: TextField by fxid("sixthSkillTextField")

    val newFileMenuItem: MenuItem by fxid("newFileMenuItem")
    val openFileMenuItem: MenuItem by fxid("openFileMenuItem")
    val openRecentFileMenu: Menu by fxid("openRecentFileMenu")
    val saveFileMenu: MenuItem by fxid("saveFileMenu")
    val saveAsFileMenu: MenuItem by fxid("saveAsFileMenu")
    val reloadFileMenu: MenuItem by fxid("reloadFileMenu")
    val applicationExitMenuItem: MenuItem by fxid("applicationExitMenuItem")

    val readLicenseMenuItem: MenuItem by fxid("readLicenseMenuItem")
    val openSources: MenuItem by fxid("openSources")
    val readChangeLogMenuItem: MenuItem by fxid("readChangeLogMenuItem")
    val supportMailMenuItem: MenuItem by fxid("supportMailMenuItem")
    val donateMenuItem: MenuItem by fxid("donateMenuItem")
    val applicationAboutMenuItem: MenuItem by fxid("applicationAboutMenuItem")

    val currentPathLabel: Label by fxid("currentPathLabel")

    val acceptLicenseCheckBox: CheckBox by fxid("acceptLicenseCheckBox")
    val allowCheckingReleaseUpdatedCheckBox: CheckBox by fxid("allowCheckingReleaseUpdatedCheckBox")
    val allowCheckingAlphaUpdatesCheckBox: CheckBox by fxid("allowCheckingAlphaUpdatesCheckBox")
    val allowApplicationTelemetryCheckBox: CheckBox by fxid("allowApplicationTelemetryCheckBox")

    //endregion

    init {
        BaseViewInstance.baseViewInstance = this
        BaseWindowSubscribeEvent.subscribe()
        LoadOpenRecentData.load()
        RunMemoryCounting.start()
        AddContentToTreeView.addContent()
        LoadApplicationSettings.load()
        SubscribeSettingsPane.subscribe()

        ApplicationLogger.logger.info("Loading SacredMagician done (${(System.currentTimeMillis() - ApplicationSummary.startTime).div(1000.0)} seconds \\ Free: ${Runtime.getRuntime().freeMemory().div(1048576)}MB of ${Runtime.getRuntime().maxMemory().div(1048576)}MB)!")
    }

    @FXML @Suppress("unused")
    private fun handleChangesBalanceBin(e: KeyEvent) {
        val s = e.source as TextField

        s.textProperty().addListener { _, oldValue, newValue ->
            if (!newValue.matches("\\d*".toRegex())) s.text = newValue.replace("[^\\d.]".toRegex(), "")

            if (newValue.length > ApplicationSummary.maxLength) s.text = oldValue
        }

        if (!ApplicationSummary.binPath.isEmpty()) balanceBinFileChanged = true
    }

    @FXML @Suppress("unused")
    private fun handleChangesIntBalanceBin(e: KeyEvent) {
        val s = e.source as TextField

        s.textProperty().addListener { _, oldValue, newValue ->
            if (!newValue.matches("\\d*".toRegex())) s.text = newValue.replace("[^\\d]".toRegex(), "")

            if (newValue.length > ApplicationSummary.maxLength) s.text = oldValue
        }

        if (!ApplicationSummary.binPath.isEmpty()) balanceBinFileChanged = true
    }
}

