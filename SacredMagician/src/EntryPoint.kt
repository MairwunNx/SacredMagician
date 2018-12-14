import bin.*
import tornadofx.*

fun main(args: Array<String>) {
    PrintSystemBaseInfo.print()
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    CreateApplicationSettings.create()
    CreateTelemetrySettings.create()
    RemoveAppTempFiles.remove()
    CheckAlphaUpdates.getPermission()
    CreateOpenRecentFile.create()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}