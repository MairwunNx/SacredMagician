package bin

import ApplicationPaths
import tornadofx.*

class SubscribeSettingsPane {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.action {
                SetValueToSettings.setValue(ApplicationPaths.appSettingsFile, "AcceptLicenseAgreements", BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.action {
                SetValueToSettings.setValue(ApplicationPaths.appSettingsFile, "AutoCheckingReleaseUpdates", BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.action {
                SetValueToSettings.setValue(ApplicationPaths.appSettingsFile, "AutoCheckingAlphaUpdates", BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.isSelected.toString())
            }

            BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.action {
                SetValueToSettings.setValue(ApplicationPaths.appSettingsFile, "AllowApplicationTelemetry", BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.isSelected.toString())
            }
        }
    }
}