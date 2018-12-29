package bin

import ApplicationLogger
import ApplicationPaths
import ApplicationSummary
import java.net.URL
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.Executors

class ApplicationSendData {
    companion object {
        fun send() {
            if (!ApplicationSummary.isOnline) return

            if (!GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AllowApplicationTelemetry").toBoolean()) return

            val executorStarts = Executors.newSingleThreadExecutor()

            executorStarts.submit {
                val time = System.currentTimeMillis()
                if (System.getProperty("user.name") != "Nynxx") {
                    val url = URL("http://mnxtelemetry.zzz.com.ua/send.php?type=sm&lnch=true")

                    try {
                        val urlConnection = url.openConnection()
                        val inputStream = urlConnection.getInputStream()

                        inputStream.close()
                        executorStarts.shutdown()

                        ApplicationLogger.logger.info("SacredMagician start-up statistics has been sent! ${(System.currentTimeMillis() - time).div(1000.0)}")
                    } catch (ex: Exception) {
                        AppPrintStackTrace.print(ex)
                    }
                }
            }

            if (GetValueFromSettings.getValue(ApplicationPaths.appStatisticFile, "TelemetryDataSended").toBoolean()) return

            val executorDownloads = Executors.newSingleThreadExecutor()

            executorDownloads.submit {
                val time = System.currentTimeMillis()
                val data = "DATA: [${LocalDateTime.now()}] | OS: [${System.getProperty("os.name")} \\ ${System.getProperty("user.name")}] | VER: [${ApplicationSummary.version} \\ ${ApplicationSummary.aVersion}] | TYPE: [${ApplicationSummary.type}]"
                val dataEncoded = Base64.getEncoder().withoutPadding().encodeToString(data.toByteArray())

                val url = URL("http://mnxtelemetry.zzz.com.ua/send.php?type=sm&data=$dataEncoded")

                try {
                    val conn = url.openConnection()
                    val inStream = conn.getInputStream()
                    inStream.close()

                    SetValueToSettings.setValue(ApplicationPaths.appStatisticFile, "TelemetryDataSended", "true")

                    ApplicationLogger.logger.info("SacredMagician anonymous statistics has been sent! ${(System.currentTimeMillis() - time).div(1000.0)}")

                    executorDownloads.shutdown()
                } catch (ex: Exception) {
                    AppPrintStackTrace.print(ex)
                }
            }
        }

        fun sendUseStat(stat: String) {
            if (!ApplicationSummary.isOnline) return

            val executorSpecData = Executors.newSingleThreadExecutor()

            executorSpecData.submit {
                if (GetValueFromSettings.getValue(ApplicationPaths.appSettingsFile, "AllowApplicationTelemetry").toBoolean()) {
                    val time = System.currentTimeMillis()
                    if (System.getProperty("user.name") != "Nynxx") {
                        val url = URL("http://mnxtelemetry.zzz.com.ua/send.php?type=sm&spec=true&stat=$stat")

                        try {
                            val urlConnection = url.openConnection()
                            val inputStream = urlConnection.getInputStream()

                            inputStream.close()
                            executorSpecData.shutdown()

                            ApplicationLogger.logger.info("SacredMagician $stat statistics has been sent! ${(System.currentTimeMillis() - time).div(1000.0)}")
                        } catch (ex: Exception) {
                            AppPrintStackTrace.print(ex)
                        }
                    }
                }
            }
        }
    }
}