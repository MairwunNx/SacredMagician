package bin

import ApplicationLogger
import ApplicationSummary

class CheckReleaseUpdates {
    companion object {
        fun getPermission() {
            ApplicationLogger.logger.info("Checking permission for checking release SacredMagician updates ...")

            if (GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "AutoCheckingReleaseUpdates").toBoolean()) {
                getLatestVersion()
            }
        }

        private fun getLatestVersion() {
            if (ApplicationActualVersion.get(ApplicationSummary.version, "release", "https://getfile.dokpub.com/yandex/get/https://yadi.sk/i/jF7bbJ8YDgrvzA")) downloadUpdate()
        }

        private fun downloadUpdate() {
            DownloadNewUpdate.download("https://getfile.dokpub.com/yandex/get/https://yadi.sk/d/HlrXhnaMb6edZQ")
        }
    }
}