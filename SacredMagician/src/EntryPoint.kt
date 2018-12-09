import bin.CreateDirectories
import bin.GetInternetConnection
import bin.PrintSystemBaseInfo
import tornadofx.*

fun main(args: Array<String>) {
    PrintSystemBaseInfo().print()
    GetInternetConnection().getCurrentSessionStatus()
    CreateDirectories().createDirectories()
    launch<ApplicationBase>(args)
}