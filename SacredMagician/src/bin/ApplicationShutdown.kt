package bin

import ApplicationLogger
import javafx.application.Platform

class ApplicationShutdown {
    companion object {
        fun shutdown() {
            ApplicationLogger.logger.info("Shutting down SacredMagician application ...")
            Platform.exit()
            System.exit(0)
        }
    }
}