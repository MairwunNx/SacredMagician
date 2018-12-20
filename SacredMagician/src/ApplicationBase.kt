import bvw.BaseView
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*

class ApplicationBase : App(Image("ico/icon.png"), BaseView::class) {
    override fun start(stage: Stage) {
        stage.initStyle(StageStyle.UNDECORATED)
        super.start(stage)
        applyStageParams(stage)
    }

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
        importStylesheet("/css/JMetroBase.css")
        importStylesheet("/css/JMetroDarkTheme.css")
    }
}