package bin

import ApplicationLogger
import ApplicationPaths
import ApplicationSummary
import java.util.concurrent.Executors

class CheckAlphaUpdates {
    companion object {
        var executor = Executors.newSingleThreadExecutor()!!

        fun getPermission() {
            if (ApplicationSummary.isOnline) {
                executor.submit {
                    ApplicationLogger.logger.info("Checking permission for checking alpha SacredMagician updates ...")

                    if (GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AutoCheckingAlphaUpdates").toBoolean()) getLatestVersion() else CheckReleaseUpdates.getPermission()
                }
            }
        }

        private fun getLatestVersion() =
                if (ApplicationActualVersion.get(ApplicationSummary.aVersion, "alpha", "https://drive.google.com/uc?export=download&id=1sogUimjseix2Kq4Es9J5M9RlLfSaNKDe")) downloadUpdate() else CheckReleaseUpdates.getPermission()

        private fun downloadUpdate() =
                DownloadNewUpdate.download("https://drive.google.com/uc?export=download&id=1tj-C7svsMs6qlzWrvfEzKtHfOrpwfXm3")
    }
}