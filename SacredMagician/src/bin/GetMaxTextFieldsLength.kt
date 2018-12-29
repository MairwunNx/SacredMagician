package bin

class GetMaxTextFieldsLength {
    companion object {
        fun get(args: Array<String>) {
            if (args.contains("-disableMaxCharsLoading")) return
            ApplicationSummary.maxLength = GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "MaxAllowedTypingChars").toInt()
            ApplicationLogger.logger.info("SacredMagician setting MaxAllowedTypingChars loaded with ${ApplicationSummary.maxLength} value!")
        }
    }
}