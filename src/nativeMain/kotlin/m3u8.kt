import io.ktor.client.*
import io.ktor.client.request.*

suspend fun m3u8Download(url: String, outputPath:String){
    val client = HttpClient()
    val m3u8Header = client.get<String> {
        url(url)
    }
    if (!formatCheck(m3u8Header)){
        println("The content from ${url}, is not m3u8 !")
        return
    }

    //TODO
    //1st, to parser the file of m3u8, getting file path of each slides
    //2nd, using multi-thread to fetch all videos and con them.
    //3rd, write into a ts file.
    //done

}

fun formatCheck(value:String):Boolean{
    val contents = value.split('\n')
    if(contents.isEmpty()){
        return false
    }
    if(!contents[0].contains("#EXTM3U")) {
        return false
    }
    //further format checker place here.
    return true
}