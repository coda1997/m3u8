import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.apply {
        launch {
            m3u8Download("http://sample.m3u8")
        }
    }
}


