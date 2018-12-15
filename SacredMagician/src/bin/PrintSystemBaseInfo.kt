package bin

import ApplicationLogger
import ApplicationSummary

class PrintSystemBaseInfo {
    companion object {
        fun print() {
            ApplicationLogger.logger.info("============================================================")

            if (ApplicationSummary.type == "Release") {
                ApplicationLogger.logger.info("Starting ${ApplicationSummary.name} utility version ${ApplicationSummary.version}")
            } else {
                ApplicationLogger.logger.info("Starting ${ApplicationSummary.name} utility version ${ApplicationSummary.aVersion}")
            }

            ApplicationLogger.logger.info("You have launched SacredMagician an official ${ApplicationSummary.type} build")

            ApplicationLogger.logger.info("SacredMagician current launched system: ${System.getProperty("os.name")}")
            ApplicationLogger.logger.info("SacredMagician current launched Java version: ${System.getProperty("java.version")}")
            ApplicationLogger.logger.info("SacredMagician current session allocated memory: ${Runtime.getRuntime().maxMemory().div(1048576)}MB")
            ApplicationLogger.logger.info("SacredMagician running by current user name profile: ${System.getProperty("user.name")}")
            ApplicationLogger.logger.info("============================================================")
        }
    }
}