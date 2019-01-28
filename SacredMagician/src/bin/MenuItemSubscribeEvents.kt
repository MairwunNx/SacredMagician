package bin

import tornadofx.*

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
                ApplicationSendData.sendUseStat("save-file")
            }

            BaseViewInstance.baseViewInstance.saveFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())
            BaseViewInstance.baseViewInstance.saveAsFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())
            BaseViewInstance.baseViewInstance.reloadFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())

            BaseViewInstance.baseViewInstance.saveAsFileMenu.action {
                SaveAsFileDialog.open()
            }

            BaseViewInstance.baseViewInstance.reloadFileMenu.action {
                LoadBalanceBinData.load()
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                ApplicationSendData.sendUseStat("reload-file")
            }

            BaseViewInstance.baseViewInstance.applicationExitMenuItem.action {
                OverwriteBalanceDialog.show("appExit")
            }

            BaseViewInstance.baseViewInstance.readLicenseMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
                ApplicationSendData.sendUseStat("read-license")
            }

            BaseViewInstance.baseViewInstance.openSources.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician")
                ApplicationSendData.sendUseStat("open-sources")
            }

            BaseViewInstance.baseViewInstance.readChangeLogMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/CHANGELOG.md")
                ApplicationSendData.sendUseStat("change-log")
            }

            BaseViewInstance.baseViewInstance.supportMailMenuItem.action {
                OpenBrowserLink.open("mailto://MairwunNx@gmail.com")
                ApplicationSendData.sendUseStat("mail-to")
            }

            BaseViewInstance.baseViewInstance.donateMenuItem.action {
                OpenBrowserLink.open("https://money.yandex.ru/to/410015993365458")
                ApplicationSendData.sendUseStat("donate-to")
            }

            BaseViewInstance.baseViewInstance.applicationAboutMenuItem.action {
                BaseViewInstance.baseViewInstance.aboutPane.isVisible = true
                ApplicationSendData.sendUseStat("about")
            }

            BaseViewInstance.baseViewInstance.openInExplorer.action {
                if (System.getProperty("os.name").contains("Windows", true)) {
                    if (BaseViewInstance.baseViewInstance.currentPathLabel.text != "Path unavailable, balance.bin file not created or not opened.") {
                        Runtime.getRuntime().exec("explorer.exe /select," + BaseViewInstance.baseViewInstance.currentPathLabel.text)
                    } else {
                        JavaMessageBox.show("Ninny! You can't open file in explorer, because you not open file! ಠ_ಠ", "ERROR")
                    }
                } else {
                    JavaMessageBox.show("Select file in explorer or open file path in explorer not available on your system! Only on windows!", "WARNING")
                }
            }

            BaseViewInstance.baseViewInstance.applicationSuMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredUtils")
                ApplicationSendData.sendUseStat("open-su")
            }

            BaseViewInstance.baseViewInstance.applicationSlMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredLumina")
                ApplicationSendData.sendUseStat("open-sl")
            }

            BaseViewInstance.baseViewInstance.applicationAddNewMenuItem.action {
                OpenBrowserLink.open("mailto:MairwunNx@gmail.com?subject=Request%20to%20add%20my%20utility.&body=Hello%20MairwunNx%2C%20please%20add%20my%20utility%20or%20project%20to%20your%20application.%0A%0AApplication%20Name%20and%20what%20it%20do%20(just%20describe%20it)%0AApplication%20Screenshots%3A%20(link%20here)%0AApplication%20Demo%20or%20Release%3A%20(link%20here)%0AApplication%20Sources%3A%20(link%20here)%0AApplication%20Video%20or%20Reviews%3A%20(link%20here)%0A%0ACheers")
            }
        }
    }
}