package bin

import tornadofx.*

class SubscribeSettingsPane {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.action {
                SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements", BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.action {
                SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates", BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.action {
                SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates", BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.action {
                SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AllowApplicationTelemetry", BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.isSelected.toString())
            }
        }
    }
}