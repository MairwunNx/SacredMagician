package bin

import javafx.scene.text.Font

class LoadApplicationFonts {
    companion object {
        fun load() {
            try {
                Font.loadFont("/fnt/segoeui.ttf", 64.0)
                Font.loadFont("/fnt/seguisb.ttf", 64.0)
                Font.loadFont("/fnt/segoeuil.ttf", 64.0)
                Font.loadFont("/fnt/segoeuisl.ttf", 64.0)
            } catch (ex: Exception) {
                AppPrintStackTrace.print(ex)
            }
        }
    }
}