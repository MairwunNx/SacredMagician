package bvw

import ApplicationSummary
import javafx.scene.layout.BorderPane
import tornadofx.*

class BaseView : View("${ApplicationSummary().name} ${ApplicationSummary().aVersion}") {
    override val root: BorderPane by fxml("/wnd/BaseWindow.fxml")
}