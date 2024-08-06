package org.haos.app.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
    println(isDark)
}

@Composable
internal actual fun SystemLocale(locale: Locale) {
}