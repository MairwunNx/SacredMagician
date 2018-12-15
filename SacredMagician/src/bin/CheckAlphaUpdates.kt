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
                if (ApplicationActualVersion.get(ApplicationSummary.aVersion, "alpha", "https://getfile.dokpub.com/yandex/get/https://yadi.sk/i/X1pywr-uYsSncw")) downloadUpdate() else CheckReleaseUpdates.getPermission()

        private fun downloadUpdate() =
                DownloadNewUpdate.download("https://getfile.dokpub.com/yandex/get/https://yadi.sk/d/2L41fmLzzC1NLw")
    }
}