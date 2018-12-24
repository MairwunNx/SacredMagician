package bin

import ApplicationLogger
import javafx.scene.control.TextField

class ValidateRegionTextFields {
    companion object {
        private val textFields: Array<TextField> = arrayOf(
                BaseViewInstance.baseViewInstance.southCenterRegionTextField,
                BaseViewInstance.baseViewInstance.northCenterRegionTextField,
                BaseViewInstance.baseViewInstance.swampBaseRegionTextField,
                BaseViewInstance.baseViewInstance.westBaseRegionTextField,
                BaseViewInstance.baseViewInstance.northBaseRegionTextField,
                BaseViewInstance.baseViewInstance.lavaBaseRegionTextField,
                BaseViewInstance.baseViewInstance.shaddarBaseRegionTextField,
                BaseViewInstance.baseViewInstance.upperUnderworldTextField,
                BaseViewInstance.baseViewInstance.lowerBaseRegionTextField
        )

        fun validate() {
            ApplicationLogger.logger.info("Validating region field values ...")

            textFields.forEach {
                if (it.text.contains('.')) {
                    ApplicationLogger.logger.warn("${it.id} contains not correct value ${it.text}!")
                    it.text = it.text.substring(0, it.text.indexOf('.'))
                    ApplicationLogger.logger.info("Fixed value for ${it.id}")
                } else {
                    ApplicationLogger.logger.info("Value of ${it.id} textfield correct!")
                }
            }
        }
    }
}