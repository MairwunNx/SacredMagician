package bin

import ApplicationLogger
import ApplicationSummary
import java.net.URL
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.Executors

class ApplicationSendData {
    companion object {
        fun send() {
            if (!ApplicationSummary.isOnline) return

            if (GetValueFromSettings.getValue("\$SacredMagician\\conf\\app.stat.toml", "TelemetryDataSended").toBoolean()) return

            val executor = Executors.newSingleThreadExecutor()

            executor.submit {
                val data = "DATA: [${LocalDateTime.now()}] | OS: [${System.getProperty("os.name")} \\ ${System.getProperty("user.name")}] | VER: [${ApplicationSummary.version} \\ ${ApplicationSummary.aVersion}] | TYPE: [${ApplicationSummary.type}]"
                val dataEncoded = Base64.getEncoder().withoutPadding().encodeToString(data.toByteArray())

                val url = URL("http://mnxtelemetry.zzz.com.ua/send.php?type=sm&data=$dataEncoded")

                try {
                    val conn = url.openConnection()
                    val inStream = conn.getInputStream()
                    inStream.close()

                    SetValueToSettings.setValue("\$SacredMagician\\conf\\app.stat.toml", "TelemetryDataSended", "true")

                    ApplicationLogger.logger.info("SacredMagician anonymous statistics has been sent!")
                } catch (ex: Exception) {
                    AppPrintStackTrace.print(ex)
                }
            }
        }
    }
}