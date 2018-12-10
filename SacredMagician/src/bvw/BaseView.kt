package bvw

import ApplicationSummary
import bin.GetBinDataByOffset
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import tornadofx.*

class BaseView : View("${ApplicationSummary().name} ${ApplicationSummary().aVersion}") {
    override val root: BorderPane by fxml("/wnd/BaseWindow.fxml")

    private val balanceBinFileChanged = false

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

    init {
        loadBalanceData()
    }

    private fun loadBalanceData() {
        southCenterRegionTextField.text = GetBinDataByOffset().get(22392, false).toString()
        northCenterRegionTextField.text = GetBinDataByOffset().get(22456, false).toString()
        swampBaseRegionTextField.text = GetBinDataByOffset().get(22520, false).toString()
        westBaseRegionTextField.text = GetBinDataByOffset().get(22584, false).toString()
        northBaseRegionTextField.text = GetBinDataByOffset().get(22648, false).toString()
        lavaBaseRegionTextField.text = GetBinDataByOffset().get(22712, false).toString()
        shaddarBaseRegionTextField.text = GetBinDataByOffset().get(22776, false).toString()
        upperUnderworldTextField.text = GetBinDataByOffset().get(22840, false).toString()
        lowerBaseRegionTextField.text = GetBinDataByOffset().get(22904, false).toString()

        bronzeAwVwTextField.text = GetBinDataByOffset().get(1832, true).toString()
        bronzeHitPointsTextField.text = GetBinDataByOffset().get(1856, true).toString()
        bronzeResistanceTextField.text = GetBinDataByOffset().get(1904, true).toString()
        bronzeDamageTextField.text = GetBinDataByOffset().get(1880, true).toString()

        silverAwVwTextField.text = GetBinDataByOffset().get(1812, true).toString()
        silverHitPointsTextField.text = GetBinDataByOffset().get(1836, true).toString()
        silverResistanceTextField.text = GetBinDataByOffset().get(1884, true).toString()
        silverDamageTextField.text = GetBinDataByOffset().get(1860, true).toString()

        goldAwVwTextField.text = GetBinDataByOffset().get(1816, true).toString()
        goldHitPointsTextField.text = GetBinDataByOffset().get(1840, true).toString()
        goldResistanceTextField.text = GetBinDataByOffset().get(1888, true).toString()
        goldDamageTextField.text = GetBinDataByOffset().get(1864, true).toString()

        platinumAwVwTextField.text = GetBinDataByOffset().get(1820, true).toString()
        platinumHitPointsTextField.text = GetBinDataByOffset().get(1844, true).toString()
        platinumResistanceTextField.text = GetBinDataByOffset().get(1892, true).toString()
        platinumDamageTextField.text = GetBinDataByOffset().get(1868, true).toString()

        niobiumAwVwTextField.text = GetBinDataByOffset().get(1824, true).toString()
        niobiumHitPointsTextField.text = GetBinDataByOffset().get(1848, true).toString()
        niobiumResistanceTextField.text = GetBinDataByOffset().get(1896, true).toString()
        niobiumDamageTextField.text = GetBinDataByOffset().get(1872, true).toString()

        multiPlayerAwVwTextField.text = GetBinDataByOffset().get(1828, true).toString()
        multiPlayerHitPointsTextField.text = GetBinDataByOffset().get(1852, true).toString()
        multiPlayerResistanceTextField.text = GetBinDataByOffset().get(1900, true).toString()
        multiPlayerDamageTextField.text = GetBinDataByOffset().get(1876, true).toString()
    }
}