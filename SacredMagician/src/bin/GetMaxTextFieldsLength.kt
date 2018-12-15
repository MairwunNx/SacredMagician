package bin

class GetMaxTextFieldsLength {
    companion object {
        fun get() {
            ApplicationSummary.maxLength = GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.setg.toml", "MaxAllowedTypingChars").toInt()
            ApplicationLogger.logger.info("SacredMagician setting MaxAllowedTypingChars loaded with ${ApplicationSummary.maxLength} value!")
        }
    }
}