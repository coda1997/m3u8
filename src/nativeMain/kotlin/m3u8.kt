import io.ktor.client.*
import io.ktor.client.request.*

suspend fun m3u8Download(url: String){
    val client = HttpClient()
    val m3u8Header = client.get<String> {
        url(url)
    }

    //TODO
    //1st, to parser the file of m3u8, getting file path of each slides
    //2nd, using multi-thread to fetch all videos and con them.
    //3rd, write into a ts file.
    //done

}