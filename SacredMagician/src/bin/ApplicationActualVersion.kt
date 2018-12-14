package bin

class ApplicationActualVersion {
    companion object {
        fun get(version: String, type: String, latestVersion: String): Boolean {
            ApplicationLogger.logger.info("Checking for $type SacredMagician application updates ...")

            val appLatestVersion = GetVersionFromLink.get(latestVersion)

            ApplicationLogger.logger.info("The last received SacredMagician $type version $appLatestVersion")

            return if (!appLatestVersion.contains(version)) {
                ApplicationLogger.logger.warn("SacredMagician application $version is outdated!")
                ApplicationLogger.logger.info("Downloading SacredMagician application $appLatestVersion update ...")
                true
            } else {
                ApplicationLogger.logger.info("SacredMagician application no need to $type update!")
                false
            }
        }
    }
}