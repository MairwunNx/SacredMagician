package bvw

import bin.ApplicationShutdown
import bin.OpenBrowserLink
import bin.SetValueToSettings
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import tornadofx.*

class LicenseView : View("SacredMagician License") {
    override val root: BorderPane by fxml("/wnd/LicenseAgreement.fxml")

    private val readLicenseButton: Button by fxid("readLicenseButton")
    private val closeAppButton: Button by fxid("closeAppButton")
    private val acceptAgreementsButton: Button by fxid("acceptAgreementsButton")

    init { subscribeEvent() }

    private fun subscribeEvent() {
        readLicenseButton.action {
            OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
        }

        closeAppButton.action {
            ApplicationShutdown.shutdown()
        }

        acceptAgreementsButton.action {
            SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements", "true")
            close()
        }
    }
}