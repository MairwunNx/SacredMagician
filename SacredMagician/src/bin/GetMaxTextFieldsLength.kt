package bin

class GetMaxTextFieldsLength {
    companion object {
        fun get(args: Array<String>) {
            if (args.contains("-disableMaxCharsLoading")) return
            ApplicationSummary.maxLength = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "MaxAllowedTypingChars").toInt()
            ApplicationLogger.logger.info("SacredMagician setting MaxAllowedTypingChars loaded with ${ApplicationSummary.maxLength} value!")
        }
    }
}