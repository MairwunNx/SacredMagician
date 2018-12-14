package bin

import ApplicationLogger
import bvw.BaseView
import tornadofx.*

class SaveBalanceBinData {
    companion object {
        fun save() {
            val baseView = find<BaseView>()

            SetBinDataToOffset.setInt(baseView.southCenterRegionTextField.text.toInt(), 22392)
            SetBinDataToOffset.setInt(baseView.northCenterRegionTextField.text.toInt(), 22456)
            SetBinDataToOffset.setInt(baseView.swampBaseRegionTextField.text.toInt(), 22520)
            SetBinDataToOffset.setInt(baseView.westBaseRegionTextField.text.toInt(), 22584)
            SetBinDataToOffset.setInt(baseView.northBaseRegionTextField.text.toInt(), 22648)
            SetBinDataToOffset.setInt(baseView.lavaBaseRegionTextField.text.toInt(), 22712)
            SetBinDataToOffset.setInt(baseView.shaddarBaseRegionTextField.text.toInt(), 22776)
            SetBinDataToOffset.setInt(baseView.upperUnderworldTextField.text.toInt(), 22840)
            SetBinDataToOffset.setInt(baseView.lowerBaseRegionTextField.text.toInt(), 22904)

            SetBinDataToOffset.setFloat(baseView.bronzeAwVwTextField.text.toFloat(), 1832)
            SetBinDataToOffset.setFloat(baseView.bronzeHitPointsTextField.text.toFloat(), 1856)
            SetBinDataToOffset.setFloat(baseView.bronzeResistanceTextField.text.toFloat(), 1904)
            SetBinDataToOffset.setFloat(baseView.bronzeDamageTextField.text.toFloat(), 1880)

            SetBinDataToOffset.setFloat(baseView.silverAwVwTextField.text.toFloat(), 1812)
            SetBinDataToOffset.setFloat(baseView.silverHitPointsTextField.text.toFloat(), 1836)
            SetBinDataToOffset.setFloat(baseView.silverResistanceTextField.text.toFloat(), 1884)
            SetBinDataToOffset.setFloat(baseView.silverDamageTextField.text.toFloat(), 1860)

            SetBinDataToOffset.setFloat(baseView.goldAwVwTextField.text.toFloat(), 1816)
            SetBinDataToOffset.setFloat(baseView.goldHitPointsTextField.text.toFloat(), 1840)
            SetBinDataToOffset.setFloat(baseView.goldResistanceTextField.text.toFloat(), 1888)
            SetBinDataToOffset.setFloat(baseView.goldDamageTextField.text.toFloat(), 1864)

            SetBinDataToOffset.setFloat(baseView.platinumAwVwTextField.text.toFloat(), 1820)
            SetBinDataToOffset.setFloat(baseView.platinumHitPointsTextField.text.toFloat(), 1844)
            SetBinDataToOffset.setFloat(baseView.platinumResistanceTextField.text.toFloat(), 1892)
            SetBinDataToOffset.setFloat(baseView.platinumDamageTextField.text.toFloat(), 1868)

            SetBinDataToOffset.setFloat(baseView.niobiumAwVwTextField.text.toFloat(), 1824)
            SetBinDataToOffset.setFloat(baseView.niobiumHitPointsTextField.text.toFloat(), 1848)
            SetBinDataToOffset.setFloat(baseView.niobiumResistanceTextField.text.toFloat(), 1896)
            SetBinDataToOffset.setFloat(baseView.niobiumDamageTextField.text.toFloat(), 1872)

            SetBinDataToOffset.setFloat(baseView.multiPlayerAwVwTextField.text.toFloat(), 1828)
            SetBinDataToOffset.setFloat(baseView.multiPlayerHitPointsTextField.text.toFloat(), 1852)
            SetBinDataToOffset.setFloat(baseView.multiPlayerResistanceTextField.text.toFloat(), 1900)
            SetBinDataToOffset.setFloat(baseView.multiPlayerDamageTextField.text.toFloat(), 1876)

            ApplicationLogger.logger.info("Balance.bin changes successfully saved to origin!")
        }
    }
}