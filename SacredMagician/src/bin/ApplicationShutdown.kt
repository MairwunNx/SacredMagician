package bin

import ApplicationLogger
import javafx.application.Platform

class ApplicationShutdown {
    companion object {
        fun shutdown() {
            ApplicationLogger.logger.info("Shutting down Updater Method thread ...")
            CheckAlphaUpdates.executor.shutdown()
            ApplicationLogger.logger.info("Shutting down SacredMagician application ...")
            Platform.exit()
            ApplicationLogger.logger.info("// GoodBye! Author: MairwunNx. Finish the Job (c) Si Begg.")
            System.exit(0)
        }
    }
}