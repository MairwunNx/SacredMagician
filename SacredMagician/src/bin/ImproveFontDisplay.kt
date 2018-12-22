package bin

class ImproveFontDisplay {
    companion object {
        fun improve(args: Array<String>) {
            if (args.contains("-improveFont=false")) return
            System.setProperty("prism.lcdtext", "false")
        }
    }
}