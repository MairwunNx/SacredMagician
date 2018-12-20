package bin

import tornadofx.*

class BaseWindowSubscribeEvent {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.gitHubButtonRect.setOnMouseClicked {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
            }

            BaseViewInstance.baseViewInstance.closeButtonRect.setOnMouseClicked {
                OverwriteBalanceDialog.show("appExit")
            }

            BaseViewInstance.baseViewInstance.applicationHeaderRect.setOnMousePressed {
                BaseViewInstance.baseViewInstance.xOffset = BaseViewInstance.baseViewInstance.primaryStage.x - it.screenX
                BaseViewInstance.baseViewInstance.yOffset = BaseViewInstance.baseViewInstance.primaryStage.y - it.screenY
            }

            BaseViewInstance.baseViewInstance.applicationHeaderRect.setOnMouseDragged {
                BaseViewInstance.baseViewInstance.primaryStage.x = it.screenX + BaseViewInstance.baseViewInstance.xOffset
                BaseViewInstance.baseViewInstance.primaryStage.y = it.screenY + BaseViewInstance.baseViewInstance.yOffset
            }

            BaseViewInstance.baseViewInstance.readLicenseButton.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
            }

            BaseViewInstance.baseViewInstance.closeAppButton.action(ApplicationShutdown.Companion::shutdown)

            BaseViewInstance.baseViewInstance.acceptAgreementsButton.action {
                SetValueToSettings.setValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements", "true")
                BaseViewInstance.baseViewInstance.licenseAgreementPane.isVisible = false
            }

            BaseViewInstance.baseViewInstance.licenseAgreementPane.isVisible = !GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AcceptLicenseAgreements").toBoolean()

            MenuItemSubscribeEvents.subscribe()
        }
    }
}