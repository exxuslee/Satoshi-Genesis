package org.haos.app.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import kotlinx.browser.document

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
}

@Composable
internal actual fun SystemLocale(locale: Locale) {
    val composeTarget = document.getElementById("ComposeTarget")
    println(composeTarget?.id)
}