package bin

import ApplicationLogger
import ApplicationSummary
import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.util.concurrent.Executors



class CheckAlphaUpdates {
    companion object {
        fun getPermission() {
            if (ApplicationSummary.isOnline) {
                val executor = Executors.newSingleThreadExecutor()

                executor.submit {
                    ApplicationLogger.logger.info("Checking permission for checking alpha SacredMagician updates ...")

                    if (GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates").toBoolean()) {
                        getLatestVersion()
                    } else {
                        CheckReleaseUpdates.getPermission()
                    }
                }
            }
        }

        private fun getLatestVersion() {
            ApplicationLogger.logger.info("Checking for alpha SacredMagician application updates ...")

            val appAlphaVersion = GetVersionFromLink.get("https://drive.google.com/uc?export=download&id=1sogUimjseix2Kq4Es9J5M9RlLfSaNKDe")

            ApplicationLogger.logger.info("The last received SacredMagician alpha version $appAlphaVersion")

            if (!appAlphaVersion.contains(ApplicationSummary.aVersion)) {
                ApplicationLogger.logger.warn("SacredMagician application ${ApplicationSummary.aVersion} is outdated!")
                ApplicationLogger.logger.info("Downloading SacredMagician application $appAlphaVersion update ...")

                downloadUpdate()
            } else {
                ApplicationLogger.logger.info("SacredMagician application no need to alpha update!")

                CheckReleaseUpdates.getPermission()
            }
        }

        private fun downloadUpdate() {
            val website = URL("https://drive.google.com/uc?export=download&id=1tj-C7svsMs6qlzWrvfEzKtHfOrpwfXm3")
            val rbc = Channels.newChannel(website.openStream())
            val fos = FileOutputStream("_newVersionSacredMagicianTemp.jar")
            fos.channel.transferFrom(rbc, 0, java.lang.Long.MAX_VALUE)
            fos.close()

            ApplicationLogger.logger.info("Downloading SacredMagician application update done!")

            downloadUpdateTool()
        }

        private fun downloadUpdateTool() {
            ApplicationLogger.logger.info("Downloading SacredMagician updater utility ...")

            val website = URL("https://drive.google.com/uc?export=download&id=1QAPcDsa_gg0T2RdH42kmWTPjaRYv9oqx")
            val rbc = Channels.newChannel(website.openStream())
            val fos = FileOutputStream("updater.jar")
            fos.channel.transferFrom(rbc, 0, java.lang.Long.MAX_VALUE)
            fos.close()

            ApplicationLogger.logger.info("Downloading SacredMagician updater utility done!")

            Platform.runLater { showUpdateDialog() }
        }

        private fun showUpdateDialog() {
            val alert = Alert(Alert.AlertType.CONFIRMATION)

            alert.title = "SacredMagician Updater"
            alert.headerText = ""
            alert.contentText = "New update available now! Want you update to new version?"

            val okButton = ButtonType("Yes", ButtonBar.ButtonData.YES)
            val noButton = ButtonType("No", ButtonBar.ButtonData.NO)

            alert.buttonTypes.setAll(okButton, noButton)

            alert.showAndWait().ifPresent { type ->
                if (type == okButton) {
                    Runtime.getRuntime().exec("java -jar updater.jar SacredMagician.jar _newVersionSacredMagicianTemp.jar")

                    ApplicationShutdown.shutdown()
                }
            }
        }
    }
}