package bin

import bvw.BaseView
import tornadofx.*

class BaseViewInstance {
    companion object {
        var baseViewInstance = find<BaseView>()
    }
}