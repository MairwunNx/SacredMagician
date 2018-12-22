import bvw.BaseView
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*

class ApplicationBase : App(Image("ico/icon.png"), BaseView::class) {
    override fun start(stage: Stage) {
        ApplicationLogger.logger.info("Applying stage style to style UNDECORATED")
        stage.initStyle(StageStyle.UNDECORATED)
        ApplicationLogger.logger.info("Starting application stage window!")
        super.start(stage)
        ApplicationLogger.logger.info("Applying application stage params!")
        applyStageParams(stage)
    }

    companion object {
        private fun applyStageParams(stage: Stage) {
            stage.apply {
                isResizable = false
                minWidth = 827.0
                maxWidth = 827.0
                width = 827.0
                minHeight = 578.0
                maxHeight = 578.0
                height = 578.0
            }

            loadStylesheets()
        }

        private fun loadStylesheets() {
            ApplicationLogger.logger.info("Applying application stylesheet")
            importStylesheet("/css/JMetroBase.css")
            importStylesheet("/css/JMetroDarkTheme.css")
        }
    }
}