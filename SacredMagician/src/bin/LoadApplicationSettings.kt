package bin

class LoadApplicationSettings {
    companion object {
        fun load() {
            BaseViewInstance.baseViewInstance.acceptLicenseCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements").toBoolean()
            BaseViewInstance.baseViewInstance.allowCheckingReleaseUpdatedCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates").toBoolean()
            BaseViewInstance.baseViewInstance.allowCheckingAlphaUpdatesCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates").toBoolean()
            BaseViewInstance.baseViewInstance.allowApplicationTelemetryCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AllowApplicationTelemetry").toBoolean()
        }
    }
}