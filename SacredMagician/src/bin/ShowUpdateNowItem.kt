package bin

class ShowUpdateNowItem {
    companion object {
        fun show() {
            BaseViewInstance.baseViewInstance.rootTreeNode.children.add(BaseViewInstance.baseViewInstance.updateNowItem)
            BaseViewInstance.baseViewInstance.treeView.root = BaseViewInstance.baseViewInstance.rootTreeNode
            ApplicationSendData.sendUseStat("updates-load")
        }
    }
}