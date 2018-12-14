package bin

import ApplicationSummary
import javafx.scene.control.Alert
import tornadofx.*
import java.awt.Desktop
import java.io.File

class MenuItemSubscribeEvents {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.newFileMenuItem.action {
                OverwriteBalanceDialog.show("newFile")
            }

            BaseViewInstance.baseViewInstance.openFileMenuItem.action {
                OverwriteBalanceDialog.show("openFile")
            }

            BaseViewInstance.baseViewInstance.saveFileMenu.action {
                SaveBalanceBinData.save()
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
            }

            BaseViewInstance.baseViewInstance.saveAsFileMenu.action {
                SaveAsFileDialog.open()
            }

            BaseViewInstance.baseViewInstance.applicationExitMenuItem.action {
                OverwriteBalanceDialog.show("appExit")
            }

            BaseViewInstance.baseViewInstance.readLicenseMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
            }

            BaseViewInstance.baseViewInstance.readChangeLogMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/CHANGELOG.md")
            }

            BaseViewInstance.baseViewInstance.supportMailMenuItem.action {
                OpenBrowserLink.open("mailto://MairwunNx@gmail.com")
            }

            BaseViewInstance.baseViewInstance.donateMenuItem.action {
                OpenBrowserLink.open("https://money.yandex.ru/to/410015993365458")
            }

            BaseViewInstance.baseViewInstance.applicationAboutMenuItem.action {
                val alert = Alert(Alert.AlertType.INFORMATION)

                alert.headerText = ""
                alert.title = "About SacredMagician"
                alert.contentText = "SacredMagician Release Version: ${ApplicationSummary.version}\nSacredMagician Alpha Version: ${ApplicationSummary.aVersion}\nSacredMagician Version Type: ${ApplicationSummary.type}\nSacredMagician Build: ${ApplicationSummary.build}\n\nThanks for using SacredMagician Balance editor!\n\nAuthor: MairwunNx, Licensed Under Apache 2.0"
                alert.show()
            }

            BaseViewInstance.baseViewInstance.openLogMenuItem.action {
                Desktop.getDesktop().open(File("\$SacredMagician\\logs\\latest.log"))
            }

            BaseViewInstance.baseViewInstance.openAppSetgMenuItem.action {
                Desktop.getDesktop().open(File("\$SacredMagician\\conf\\app.setg.toml"))
            }
        }
    }
}