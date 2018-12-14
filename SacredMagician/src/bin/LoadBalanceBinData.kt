package bin

import bvw.BaseView
import tornadofx.*

class LoadBalanceBinData {
    companion object {
        fun load() {
            val baseView = find<BaseView>()

            baseView.southCenterRegionTextField.text = GetBinDataByOffset.get(22392, false).toString()
            baseView.northCenterRegionTextField.text = GetBinDataByOffset.get(22456, false).toString()
            baseView.swampBaseRegionTextField.text = GetBinDataByOffset.get(22520, false).toString()
            baseView.westBaseRegionTextField.text = GetBinDataByOffset.get(22584, false).toString()
            baseView.northBaseRegionTextField.text = GetBinDataByOffset.get(22648, false).toString()
            baseView.lavaBaseRegionTextField.text = GetBinDataByOffset.get(22712, false).toString()
            baseView.shaddarBaseRegionTextField.text = GetBinDataByOffset.get(22776, false).toString()
            baseView.upperUnderworldTextField.text = GetBinDataByOffset.get(22840, false).toString()
            baseView.lowerBaseRegionTextField.text = GetBinDataByOffset.get(22904, false).toString()

            baseView.bronzeAwVwTextField.text = GetBinDataByOffset.get(1832, true).toString()
            baseView.bronzeHitPointsTextField.text = GetBinDataByOffset.get(1856, true).toString()
            baseView.bronzeResistanceTextField.text = GetBinDataByOffset.get(1904, true).toString()
            baseView.bronzeDamageTextField.text = GetBinDataByOffset.get(1880, true).toString()

            baseView.silverAwVwTextField.text = GetBinDataByOffset.get(1812, true).toString()
            baseView.silverHitPointsTextField.text = GetBinDataByOffset.get(1836, true).toString()
            baseView.silverResistanceTextField.text = GetBinDataByOffset.get(1884, true).toString()
            baseView.silverDamageTextField.text = GetBinDataByOffset.get(1860, true).toString()

            baseView.goldAwVwTextField.text = GetBinDataByOffset.get(1816, true).toString()
            baseView.goldHitPointsTextField.text = GetBinDataByOffset.get(1840, true).toString()
            baseView.goldResistanceTextField.text = GetBinDataByOffset.get(1888, true).toString()
            baseView.goldDamageTextField.text = GetBinDataByOffset.get(1864, true).toString()

            baseView.platinumAwVwTextField.text = GetBinDataByOffset.get(1820, true).toString()
            baseView.platinumHitPointsTextField.text = GetBinDataByOffset.get(1844, true).toString()
            baseView.platinumResistanceTextField.text = GetBinDataByOffset.get(1892, true).toString()
            baseView.platinumDamageTextField.text = GetBinDataByOffset.get(1868, true).toString()

            baseView.niobiumAwVwTextField.text = GetBinDataByOffset.get(1824, true).toString()
            baseView.niobiumHitPointsTextField.text = GetBinDataByOffset.get(1848, true).toString()
            baseView.niobiumResistanceTextField.text = GetBinDataByOffset.get(1896, true).toString()
            baseView.niobiumDamageTextField.text = GetBinDataByOffset.get(1872, true).toString()

            baseView.multiPlayerAwVwTextField.text = GetBinDataByOffset.get(1828, true).toString()
            baseView.multiPlayerHitPointsTextField.text = GetBinDataByOffset.get(1852, true).toString()
            baseView.multiPlayerResistanceTextField.text = GetBinDataByOffset.get(1900, true).toString()
            baseView.multiPlayerDamageTextField.text = GetBinDataByOffset.get(1876, true).toString()
        }
    }
}