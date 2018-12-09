import bin.CreateDirectories
import bin.GetInternetConnection
import bin.PrintSystemBaseInfo

fun main(args: Array<String>) {
    PrintSystemBaseInfo().print()
    GetInternetConnection().getCurrentSessionStatus()
    CreateDirectories().createDirectories()
}