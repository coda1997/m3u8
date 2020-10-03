import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import platform.posix.*

fun m3u8Download(url: String, outputPath: String, num:Int = 50) = GlobalScope.launch {
    val client = HttpClient()
    val m3u8Header = client.get<String> {
        url(url)
    }
    if (!formatCheck(m3u8Header)) {
        println("The content from ${url}, is not m3u8 !")
        return@launch
    }

    val channel = Channel<String>(capacity = num)

    //1st, to parser the file of m3u8, getting file path of each slides
    async {
        m3u8Header.split('\n').filter { !it.startsWith('#') }.forEach {
            channel.send(it)
        }
        channel.close()
    }
    //TODO

    channel.consumeEach {

    }

    //2nd, using multi-thread to fetch all videos and con them.
    //3rd, write into a ts file.
    //done
}

fun sample() {
    val file = fopen(__filename = "filename", __mode = "r")
}

fun formatCheck(value: String): Boolean {
    val contents = value.split('\n')
    if (contents.isEmpty()) {
        return false
    }
    if (!contents[0].contains("#EXTM3U")) {
        return false
    }
    //further format checker place here.
    return true
}