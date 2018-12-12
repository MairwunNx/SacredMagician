import bin.*
import tornadofx.*

fun main(args: Array<String>) {
    PrintSystemBaseInfo.print()
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    CreateOpenRecentFile.create()
    CreateApplicationSettings.create()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}