package bin

class OpenRecentOpenPath {
    companion object {
        fun open(path: String) {
            ApplicationSummary.binPath = path
            BaseViewInstance.baseViewInstance.currentPathLabel.text = ApplicationSummary.binPath
            BaseViewInstance.baseViewInstance.balanceBinFileOpened = true
            BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
            BaseViewInstance.baseViewInstance.openOrCreateLabel.isVisible = false
            BaseViewInstance.baseViewInstance.selectFileLabel.isVisible = true
            LoadBalanceBinData.load()

            ApplicationLogger.logger.info("File path: $path opened by user in Open Recent")

            ApplicationSendData.sendUseStat("open-recent")
        }
    }
}