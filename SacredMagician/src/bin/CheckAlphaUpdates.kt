package bin

import ApplicationLogger
import ApplicationSummary
import java.util.concurrent.Executors

class CheckAlphaUpdates {
    companion object {
        fun getPermission() {
            if (ApplicationSummary.isOnline) {
                val executor = Executors.newSingleThreadExecutor()

                executor.submit {
                    ApplicationLogger.logger.info("Checking permission for checking alpha SacredMagician updates ...")

                    if (GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingAlphaUpdates").toBoolean()) getLatestVersion() else CheckReleaseUpdates.getPermission()
                }
            }
        }

        private fun getLatestVersion() =
                if (ApplicationActualVersion.get(ApplicationSummary.aVersion, "alpha", "https://drive.google.com/uc?export=download&id=1sogUimjseix2Kq4Es9J5M9RlLfSaNKDe")) downloadUpdate() else CheckReleaseUpdates.getPermission()

        private fun downloadUpdate() =
                DownloadNewUpdate.download("https://drive.google.com/uc?export=download&id=1tj-C7svsMs6qlzWrvfEzKtHfOrpwfXm3")
    }
}