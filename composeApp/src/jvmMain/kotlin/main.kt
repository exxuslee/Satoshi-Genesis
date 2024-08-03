import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.haos.app.App
import java.awt.Dimension

fun main() = application {
    Window(
        title = "desktop",
        state = rememberWindowState(width = 360.dp, height = 640.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(360, 640)
        App()
    }
}