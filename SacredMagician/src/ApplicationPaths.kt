class ApplicationPaths {
    companion object {
        const val baseAppDirectory: String = "\$SacredMagician"
        val configDirectory: String = "\$SacredMagician${ApplicationSummary.slash}conf"
        val loggerDirectory: String = "\$SacredMagician${ApplicationSummary.slash}logs"
        val appSettingsFile: String = "\$SacredMagician${ApplicationSummary.slash}conf${ApplicationSummary.slash}app.setg.toml"
        val appStatisticFile: String = "\$SacredMagician${ApplicationSummary.slash}conf${ApplicationSummary.slash}app.stat.toml"
        val openRecentFile: String = "\$SacredMagician${ApplicationSummary.slash}conf${ApplicationSummary.slash}app.rcnt.txt"
        const val updaterFile: String = "updater.jar"
        const val newUpdateFile: String = "_newVersionSacredMagicianTemp.jar"
    }
}