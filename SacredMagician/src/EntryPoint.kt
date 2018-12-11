import bin.ApplicationSendData
import bin.CreateDirectories
import bin.GetInternetConnection
import bin.PrintSystemBaseInfo
import tornadofx.*

fun main(args: Array<String>) {
    PrintSystemBaseInfo.print()
    GetInternetConnection.getCurrentSessionStatus()
    CreateDirectories.createDirectories()
    ApplicationSendData.send()
    launch<ApplicationBase>(args)
}