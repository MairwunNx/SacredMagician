package bin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class GetVersionFromLink {
    companion object {
        fun get(link: String): String {
            val url = URL(link)
            val reader = BufferedReader(InputStreamReader(url.openStream()))
            return reader.readLine().toString()
        }
    }
}