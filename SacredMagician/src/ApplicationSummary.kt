class ApplicationSummary {
    companion object {
        const val name: String = "SacredMagician"
        const val version: String = "1.0.1.0.261218.R2"
        const val aVersion: String = "1.0.0.0.151218.A1"
        const val type: String = "Release"
        var maxLength: Int = 4
        var isOnline: Boolean = false
        var binPath: String = ""
        var startTime: Long = 0
        val slash = System.getProperty("file.separator")!!
    }
}