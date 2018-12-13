package bin

import ApplicationLogger
import ApplicationSummary
import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import java.awt.Desktop
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels

class CheckReleaseUpdates {
    companion object {
        fun getPermission() {
            ApplicationLogger.logger.info("Checking permission for checking release SacredMagician updates ...")

            if (GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates").toBoolean()) {
                getLatestVersion()
            }
        }

        private fun getLatestVersion() {
            ApplicationLogger.logger.info("Checking for release SacredMagician application updates ...")

            val appAlphaVersion = GetVersionFromLink.get("https://drive.google.com/uc?export=download&id=1vOfI-eWVFnMaF8nKNv8rwoTTwMQ6YGkt")

            ApplicationLogger.logger.info("The last received SacredMagician release version $appAlphaVersion")

            if (!appAlphaVersion.contains(ApplicationSummary.version)) {
                ApplicationLogger.logger.warn("SacredMagician application ${ApplicationSummary.version} is outdated!")
                ApplicationLogger.logger.info("Downloading SacredMagician application $appAlphaVersion update ...")

                downloadUpdate()
            } else {
                ApplicationLogger.logger.info("SacredMagician application no need to release update!")
            }
        }

        private fun downloadUpdate() {
            val website = URL("https://drive.google.com/uc?export=download&id=13t88XU7uT0DtrtSqVpaB8eRtu2cSebtx")
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
                    Desktop.getDesktop().open(File("updater.jar"))

                    ApplicationShutdown.shutdown()
                }
            }
        }
    }
}