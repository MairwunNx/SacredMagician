import bin.*
import tornadofx.*

fun main(args: Array<String>) {
    ApplicationSummary.startTime = System.currentTimeMillis()
    LoadApplicationFonts.load(args)
    ImproveFontDisplay.improve(args)
    PrintSystemBaseInfo.print(args)
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    CreateApplicationSettings.create()
    CreateTelemetrySettings.create()
    RemoveAppTempFiles.remove(args)
    CreateOpenRecentFile.create()
    GetMaxTextFieldsLength.get(args)
    CheckAlphaUpdates.getPermission()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}