import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.haos.app.App


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("Multiplatform App", "ComposeTarget") {
        App()
    }
}
