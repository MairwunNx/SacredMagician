package bin

import ApplicationLogger
import ApplicationPaths
import ApplicationSummary

class CheckReleaseUpdates {
    companion object {
        fun getPermission() {
            ApplicationLogger.logger.info("Checking permission for checking release SacredMagician updates ...")

            if (GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AutoCheckingReleaseUpdates").toBoolean()) getLatestVersion()
        }

        private fun getLatestVersion() {
            if (ApplicationActualVersion.get(ApplicationSummary.version, "release", "https://drive.google.com/uc?export=download&id=1vOfI-eWVFnMaF8nKNv8rwoTTwMQ6YGkt")) downloadUpdate()
        }

        private fun downloadUpdate() =
                DownloadNewUpdate.download("https://drive.google.com/uc?export=download&id=13t88XU7uT0DtrtSqVpaB8eRtu2cSebtx")
    }
}