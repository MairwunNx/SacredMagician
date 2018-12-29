class ApplicationSummary {
    companion object {
        const val name: String = "SacredMagician"
        const val version: String = "1.0.1.1.291218.R3"
        const val aVersion: String = "1.0.0.0.151218.A1"
        const val type: String = "Release"
        val slash: String = System.getProperty("file.separator")!!
        var maxLength: Int = 4
        var isOnline: Boolean = false
        var binPath: String = ""
        var startTime: Long = 0
    }
}