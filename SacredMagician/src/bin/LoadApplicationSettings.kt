package bin

class LoadApplicationSettings {
    companion object {
        fun load() {
            BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.isSelected = GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AcceptLicenseAgreements").toBoolean()
            BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.isSelected = GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AutoCheckingReleaseUpdates").toBoolean()
            BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.isSelected = GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AutoCheckingAlphaUpdates").toBoolean()
            BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.isSelected = GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AllowApplicationTelemetry").toBoolean()
        }
    }
}