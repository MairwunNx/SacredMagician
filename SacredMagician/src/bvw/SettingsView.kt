package bvw

import bin.GetValueFromSettings
import bin.SetValueToSettings
import javafx.scene.control.CheckBox
import javafx.scene.layout.BorderPane
import tornadofx.*

class SettingsView : View("SacredMagician Settings") {
    override val root: BorderPane by fxml("/wnd/SettingsWindow.fxml")

    private val acceptLicenseCheckBox: CheckBox by fxid("acceptLicenseCheckBox")
    private val allowCheckingReleaseUpdatedCheckBox: CheckBox by fxid("allowCheckingReleaseUpdatedCheckBox")
    private val allowCheckingAlphaUpdatesCheckBox: CheckBox by fxid("allowCheckingAlphaUpdatesCheckBox")
    private val allowApplicationTelemetryCheckBox: CheckBox by fxid("allowApplicationTelemetryCheckBox")

    init {
        loadApplicationSettings()
        subscribeEvent()
    }

    private fun loadApplicationSettings() {
        acceptLicenseCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements").toBoolean()
        allowCheckingReleaseUpdatedCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates").toBoolean()
        allowCheckingAlphaUpdatesCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates").toBoolean()
        allowApplicationTelemetryCheckBox.isSelected = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AllowApplicationTelemetry").toBoolean()
    }

    private fun subscribeEvent() {
        acceptLicenseCheckBox.action {
            SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements", acceptLicenseCheckBox.isSelected.toString())
        }

        allowCheckingReleaseUpdatedCheckBox.action {
            SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates", allowCheckingReleaseUpdatedCheckBox.isSelected.toString())
        }

        allowCheckingAlphaUpdatesCheckBox.action {
            SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates", allowCheckingAlphaUpdatesCheckBox.isSelected.toString())
        }

        allowApplicationTelemetryCheckBox.action {
            SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AllowApplicationTelemetry", allowApplicationTelemetryCheckBox.isSelected.toString())
        }
    }
}