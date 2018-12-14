package bin

import ApplicationLogger

class SaveBalanceBinData {
    companion object {
        fun save() {
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.southCenterRegionTextField.text.toInt(), 22392)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.northCenterRegionTextField.text.toInt(), 22456)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.swampBaseRegionTextField.text.toInt(), 22520)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.westBaseRegionTextField.text.toInt(), 22584)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.northBaseRegionTextField.text.toInt(), 22648)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.lavaBaseRegionTextField.text.toInt(), 22712)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.shaddarBaseRegionTextField.text.toInt(), 22776)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.upperUnderworldTextField.text.toInt(), 22840)
            SetBinDataToOffset.setInt(BaseViewInstance.baseViewInstance.lowerBaseRegionTextField.text.toInt(), 22904)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.bronzeAwVwTextField.text.toFloat(), 1832)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.bronzeHitPointsTextField.text.toFloat(), 1856)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.bronzeResistanceTextField.text.toFloat(), 1904)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.bronzeDamageTextField.text.toFloat(), 1880)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.silverAwVwTextField.text.toFloat(), 1812)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.silverHitPointsTextField.text.toFloat(), 1836)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.silverResistanceTextField.text.toFloat(), 1884)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.silverDamageTextField.text.toFloat(), 1860)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.goldAwVwTextField.text.toFloat(), 1816)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.goldHitPointsTextField.text.toFloat(), 1840)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.goldResistanceTextField.text.toFloat(), 1888)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.goldDamageTextField.text.toFloat(), 1864)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.platinumAwVwTextField.text.toFloat(), 1820)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.platinumHitPointsTextField.text.toFloat(), 1844)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.platinumResistanceTextField.text.toFloat(), 1892)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.platinumDamageTextField.text.toFloat(), 1868)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.niobiumAwVwTextField.text.toFloat(), 1824)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.niobiumHitPointsTextField.text.toFloat(), 1848)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.niobiumResistanceTextField.text.toFloat(), 1896)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.niobiumDamageTextField.text.toFloat(), 1872)

            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.multiPlayerAwVwTextField.text.toFloat(), 1828)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.multiPlayerHitPointsTextField.text.toFloat(), 1852)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.multiPlayerResistanceTextField.text.toFloat(), 1900)
            SetBinDataToOffset.setFloat(BaseViewInstance.baseViewInstance.multiPlayerDamageTextField.text.toFloat(), 1876)

            ApplicationLogger.logger.info("Balance.bin changes successfully saved to origin!")
        }
    }
}