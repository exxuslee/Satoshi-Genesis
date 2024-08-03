package org.haos.app.screens.puzzle

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.app.navigations.SlideTransition
import org.haos.app.theme.ComposeAppTheme

@OptIn(ExperimentalVoyagerApi::class)
class PuzzleScreen : Screen, ScreenTransition by SlideTransition() {
    @Composable
    override fun Content() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = ComposeAppTheme.colors.elenaD) {

        }
    }
}