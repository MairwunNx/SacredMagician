package bin

import java.awt.Desktop
import java.net.URI

class OpenBrowserLink {
    companion object {
        fun open(link: String) {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) Desktop.getDesktop().browse(URI(link))
        }
    }
}