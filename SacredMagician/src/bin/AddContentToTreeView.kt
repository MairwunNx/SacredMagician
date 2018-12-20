package bin

import javafx.scene.control.TreeItem
import java.awt.Desktop
import java.io.File

class AddContentToTreeView {
    companion object {
        fun addContent() {
            BaseViewInstance.baseViewInstance.balanceSettings.children.add(TreeItem<String>("Bronze"))
            BaseViewInstance.baseViewInstance.balanceSettings.children.add(TreeItem<String>("Silver"))
            BaseViewInstance.baseViewInstance.balanceSettings.children.add(TreeItem<String>("Golden"))
            BaseViewInstance.baseViewInstance.balanceSettings.children.add(TreeItem<String>("Platinum"))
            BaseViewInstance.baseViewInstance.balanceSettings.children.add(TreeItem<String>("Niobium"))
            BaseViewInstance.baseViewInstance.balanceSettings.isExpanded = true

            BaseViewInstance.baseViewInstance.serverBalanceSettings.children.add(TreeItem<String>("Global"))
            BaseViewInstance.baseViewInstance.serverBalanceSettings.isExpanded = true

            BaseViewInstance.baseViewInstance.rootTreeNode.children.add(BaseViewInstance.baseViewInstance.balanceSettings)
            BaseViewInstance.baseViewInstance.rootTreeNode.children.add(BaseViewInstance.baseViewInstance.serverBalanceSettings)
            BaseViewInstance.baseViewInstance.rootTreeNode.children.add(BaseViewInstance.baseViewInstance.regionsQtySettings)
            BaseViewInstance.baseViewInstance.rootTreeNode.children.add(BaseViewInstance.baseViewInstance.applicationSettings)

            BaseViewInstance.baseViewInstance.treeView.root = BaseViewInstance.baseViewInstance.rootTreeNode

            BaseViewInstance.baseViewInstance.treeView.setOnMouseClicked {
                with(BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem) {
                    isExpanded = !isExpanded
                }

                BaseViewInstance.baseViewInstance.bronzeSettingsPanel.isVisible = isNeededPane("Bronze")
                BaseViewInstance.baseViewInstance.silverSettingsPanel.isVisible = isNeededPane("Silver")
                BaseViewInstance.baseViewInstance.goldenSettingsPanel.isVisible = isNeededPane("Golden")
                BaseViewInstance.baseViewInstance.platinumSettingsPanel.isVisible = isNeededPane("Platinum")
                BaseViewInstance.baseViewInstance.niobiumSettingsPanel.isVisible = isNeededPane("Niobium")
                BaseViewInstance.baseViewInstance.serverSettingsPanel.isVisible = isNeededPane("Global")
                BaseViewInstance.baseViewInstance.regionQtySettingsPanel.isVisible = isNeededPane("Regions-Qty")
                BaseViewInstance.baseViewInstance.applicationSettingsPanel.isVisible = isNeededPane("Application")

                if (BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem.value == "Update Now!") {
                    Desktop.getDesktop().open(File("updater.jar"))
                    ApplicationShutdown.shutdown()
                }
            }
        }

        private fun isNeededPane(name: String): Boolean {
            if (!BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem.value.isNullOrEmpty()) {
                if (BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem.value != "Balance" && BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem.value != "Server") {
                    BaseViewInstance.baseViewInstance.notSelectedPanel.isVisible = false
                    BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
                    return BaseViewInstance.baseViewInstance.treeView.selectionModel.selectedItem.value == name
                } else {
                    BaseViewInstance.baseViewInstance.notSelectedPanel.isVisible = true
                    BaseViewInstance.baseViewInstance.selectFileLabel.isVisible = true
                    BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
                }
            }

            return false
        }
    }
}