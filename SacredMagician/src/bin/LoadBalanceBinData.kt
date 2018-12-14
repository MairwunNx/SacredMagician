package bin

class LoadBalanceBinData {
    companion object {
        fun load() {
            BaseViewInstance.baseViewInstance.southCenterRegionTextField.text = GetBinDataByOffset.get(22392, false).toString()
            BaseViewInstance.baseViewInstance.northCenterRegionTextField.text = GetBinDataByOffset.get(22456, false).toString()
            BaseViewInstance.baseViewInstance.swampBaseRegionTextField.text = GetBinDataByOffset.get(22520, false).toString()
            BaseViewInstance.baseViewInstance.westBaseRegionTextField.text = GetBinDataByOffset.get(22584, false).toString()
            BaseViewInstance.baseViewInstance.northBaseRegionTextField.text = GetBinDataByOffset.get(22648, false).toString()
            BaseViewInstance.baseViewInstance.lavaBaseRegionTextField.text = GetBinDataByOffset.get(22712, false).toString()
            BaseViewInstance.baseViewInstance.shaddarBaseRegionTextField.text = GetBinDataByOffset.get(22776, false).toString()
            BaseViewInstance.baseViewInstance.upperUnderworldTextField.text = GetBinDataByOffset.get(22840, false).toString()
            BaseViewInstance.baseViewInstance.lowerBaseRegionTextField.text = GetBinDataByOffset.get(22904, false).toString()

            BaseViewInstance.baseViewInstance.bronzeAwVwTextField.text = GetBinDataByOffset.get(1832, true).toString()
            BaseViewInstance.baseViewInstance.bronzeHitPointsTextField.text = GetBinDataByOffset.get(1856, true).toString()
            BaseViewInstance.baseViewInstance.bronzeResistanceTextField.text = GetBinDataByOffset.get(1904, true).toString()
            BaseViewInstance.baseViewInstance.bronzeDamageTextField.text = GetBinDataByOffset.get(1880, true).toString()

            BaseViewInstance.baseViewInstance.silverAwVwTextField.text = GetBinDataByOffset.get(1812, true).toString()
            BaseViewInstance.baseViewInstance.silverHitPointsTextField.text = GetBinDataByOffset.get(1836, true).toString()
            BaseViewInstance.baseViewInstance.silverResistanceTextField.text = GetBinDataByOffset.get(1884, true).toString()
            BaseViewInstance.baseViewInstance.silverDamageTextField.text = GetBinDataByOffset.get(1860, true).toString()

            BaseViewInstance.baseViewInstance.goldAwVwTextField.text = GetBinDataByOffset.get(1816, true).toString()
            BaseViewInstance.baseViewInstance.goldHitPointsTextField.text = GetBinDataByOffset.get(1840, true).toString()
            BaseViewInstance.baseViewInstance.goldResistanceTextField.text = GetBinDataByOffset.get(1888, true).toString()
            BaseViewInstance.baseViewInstance.goldDamageTextField.text = GetBinDataByOffset.get(1864, true).toString()

            BaseViewInstance.baseViewInstance.platinumAwVwTextField.text = GetBinDataByOffset.get(1820, true).toString()
            BaseViewInstance.baseViewInstance.platinumHitPointsTextField.text = GetBinDataByOffset.get(1844, true).toString()
            BaseViewInstance.baseViewInstance.platinumResistanceTextField.text = GetBinDataByOffset.get(1892, true).toString()
            BaseViewInstance.baseViewInstance.platinumDamageTextField.text = GetBinDataByOffset.get(1868, true).toString()

            BaseViewInstance.baseViewInstance.niobiumAwVwTextField.text = GetBinDataByOffset.get(1824, true).toString()
            BaseViewInstance.baseViewInstance.niobiumHitPointsTextField.text = GetBinDataByOffset.get(1848, true).toString()
            BaseViewInstance.baseViewInstance.niobiumResistanceTextField.text = GetBinDataByOffset.get(1896, true).toString()
            BaseViewInstance.baseViewInstance.niobiumDamageTextField.text = GetBinDataByOffset.get(1872, true).toString()

            BaseViewInstance.baseViewInstance.multiPlayerAwVwTextField.text = GetBinDataByOffset.get(1828, true).toString()
            BaseViewInstance.baseViewInstance.multiPlayerHitPointsTextField.text = GetBinDataByOffset.get(1852, true).toString()
            BaseViewInstance.baseViewInstance.multiPlayerResistanceTextField.text = GetBinDataByOffset.get(1900, true).toString()
            BaseViewInstance.baseViewInstance.multiPlayerDamageTextField.text = GetBinDataByOffset.get(1876, true).toString()
        }
    }
}