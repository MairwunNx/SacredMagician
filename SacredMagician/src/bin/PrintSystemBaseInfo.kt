package bin

import ApplicationLogger
import ApplicationSummary

class PrintSystemBaseInfo {
    companion object {
        fun print(args: Array<String>) {
            if (args.contains("-disableBaseInfo")) return

            ApplicationLogger.logger.info("============================================================")
            ApplicationLogger.logger.info("Starting ${ApplicationSummary.name} utility version ${ApplicationSummary.version}")
            ApplicationLogger.logger.info("You have launched SacredMagician an official ${ApplicationSummary.type} build")
            ApplicationLogger.logger.info("SacredMagician current launched system: ${System.getProperty("os.name")}")
            ApplicationLogger.logger.info("SacredMagician current launched Java version: ${System.getProperty("java.version")}")
            ApplicationLogger.logger.info("SacredMagician current session allocated memory: ${Runtime.getRuntime().maxMemory().div(1048576)}MB")
            ApplicationLogger.logger.info("SacredMagician running by current user name profile: ${System.getProperty("user.name")}")
            ApplicationLogger.logger.info("============================================================")
        }
    }
}