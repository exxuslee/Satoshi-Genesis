package org.haos.app.screens.key

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.haos.app.screens.key.models.KeyEvent
import org.haos.app.screens.key.models.KeyViewState
import org.haos.app.theme.AppTheme
import org.haos.app.theme.ComposeAppTheme
import org.haos.app.ui.headline2_tyler
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import satoshi_genesis.composeapp.generated.resources.Res
import satoshi_genesis.composeapp.generated.resources.anime

@Composable
fun KeyView(
    viewState: KeyViewState, eventHandler: (KeyEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ComposeAppTheme.colors.elenaD
    ) {
        var textOffset by remember { mutableStateOf(Offset.Zero) }
        var textVisible by remember { mutableStateOf(false) }

        val scope = rememberCoroutineScope()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        textOffset = offset
                        textVisible = true
                        scope.launch {
                            delay(500) // Задержка для отображения текста
                            textVisible = false
                        }
                    }
                }
        ) {
            Image(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                painter = painterResource(Res.drawable.anime),
                contentDescription = "avatar",
            )
            if (textVisible) { AnimatedText("+1", textOffset) }
        }
    }
}

@Composable
fun AnimatedText(text: String, offset: Offset) {
    var alpha by remember { mutableStateOf(1f) }
    var yOffset by remember { mutableStateOf(offset.y) }

    LaunchedEffect(Unit) {
        launch {
            delay(1000)
            alpha = 0f
        }
        launch {
            for (i in 1..100) {
                yOffset -= 1
                delay(10)
            }
        }
    }

    headline2_tyler(
        text = text,
        modifier = Modifier
            .alpha(alpha)
            .offset { IntOffset(offset.x.toInt(), yOffset.toInt()) },
    )
}


@Composable
@Preview
fun KeyView_Preview() {
    AppTheme {
        KeyView(viewState = KeyViewState()) {}
    }
}