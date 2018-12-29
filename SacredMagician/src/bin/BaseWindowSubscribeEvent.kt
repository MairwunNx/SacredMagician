package bin

import ApplicationPaths
import tornadofx.*

class BaseWindowSubscribeEvent {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.gitHubButtonRect.setOnMouseClicked {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
                ApplicationSendData.sendUseStat("github-rect")
            }

            BaseViewInstance.baseViewInstance.gitHubButtonSvg.setOnMouseClicked {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
                ApplicationSendData.sendUseStat("github-rect")
            }

            BaseViewInstance.baseViewInstance.closeButtonRect.setOnMouseClicked {
                OverwriteBalanceDialog.show("appExit")
            }

            BaseViewInstance.baseViewInstance.closeButtonSvg.setOnMouseClicked {
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
                ApplicationSendData.sendUseStat("read-license")
            }

            BaseViewInstance.baseViewInstance.closeAppButton.action(ApplicationShutdown.Companion::shutdown)

            BaseViewInstance.baseViewInstance.acceptAgreementsButton.action {
                SetValueToSettings.setValue(ApplicationPaths.appSettingsFile, "AcceptLicenseAgreements", "true")
                BaseViewInstance.baseViewInstance.licenseAgreementPane.isVisible = false
                ApplicationSendData.sendUseStat("accept-agreements")
            }

            BaseViewInstance.baseViewInstance.currentPathLabel.setOnMouseEntered {
                BaseViewInstance.baseViewInstance.tooltip.text = BaseViewInstance.baseViewInstance.currentPathLabel.text
                BaseViewInstance.baseViewInstance.currentPathLabel.tooltip = BaseViewInstance.baseViewInstance.tooltip
            }

            BaseViewInstance.baseViewInstance.licenseAgreementPane.isVisible = !GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AcceptLicenseAgreements").toBoolean()

            BaseViewInstance.baseViewInstance.closeDialogButtonRect.setOnMouseClicked {
                BaseViewInstance.baseViewInstance.aboutPane.isVisible = false
            }

            BaseViewInstance.baseViewInstance.closeDialogButtonSvg.setOnMouseClicked {
                BaseViewInstance.baseViewInstance.aboutPane.isVisible = false
            }

            BaseViewInstance.baseViewInstance.aboutDialogBackground.setOnMouseClicked {
                BaseViewInstance.baseViewInstance.aboutPane.isVisible = false
            }

            MenuItemSubscribeEvents.subscribe()
        }
    }
}