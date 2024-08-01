package org.haos.app.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.haos.app.ui.title2_leah

class QubitScreen : Screen {
    @Composable
    override fun Content() {
        title2_leah(
            "C Днем Рождения, Глеб!",
            modifier = Modifier.fillMaxSize().padding(48.dp),
            textAlign = TextAlign.Center
        )
    }
}