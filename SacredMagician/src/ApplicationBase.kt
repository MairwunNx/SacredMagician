
import bin.ApplicationShutdown
import bvw.BaseView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*

class ApplicationBase : App(Image("ico/icon.png"), BaseView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        applyStageParams(stage)
    }

    private fun applyStageParams(stage: Stage) {
        stage.apply {
            minWidth = 1100.0
            maxWidth = 1100.0
            width = 1100.0
            minHeight = 550.0
            maxHeight = 550.0
            height = 550.0

            setOnCloseRequest {
                ApplicationShutdown.shutdown()
            }
        }
    }
}