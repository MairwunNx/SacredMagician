import bin.*
import tornadofx.*

fun main(args: Array<String>) {
    ApplicationSummary.startTime = System.currentTimeMillis()

    PrintSystemBaseInfo.print()
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    CreateApplicationSettings.create()
    CreateTelemetrySettings.create()
    RemoveAppTempFiles.remove()
    CreateOpenRecentFile.create()
    GetMaxTextFieldsLength.get()
    CheckAlphaUpdates.getPermission()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}