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
        southCenterRegionTextField.text = GetBinDataByOffset().get(22392).toString()
        northCenterRegionTextField.text = GetBinDataByOffset().get(22456).toString()
        swampBaseRegionTextField.text = GetBinDataByOffset().get(22520).toString()
        westBaseRegionTextField.text = GetBinDataByOffset().get(22584).toString()
        northBaseRegionTextField.text = GetBinDataByOffset().get(22648).toString()
        lavaBaseRegionTextField.text = GetBinDataByOffset().get(22712).toString()
        shaddarBaseRegionTextField.text = GetBinDataByOffset().get(22776).toString()
        upperUnderworldTextField.text = GetBinDataByOffset().get(22840).toString()
        lowerBaseRegionTextField.text = GetBinDataByOffset().get(22904).toString()
    }
}