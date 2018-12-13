import bin.*
import tornadofx.*

fun main(args: Array<String>) {
    PrintSystemBaseInfo.print()
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    CreateApplicationSettings.create()
    CreateOpenRecentFile.create()
    RemoveAppTempFiles.remove()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}