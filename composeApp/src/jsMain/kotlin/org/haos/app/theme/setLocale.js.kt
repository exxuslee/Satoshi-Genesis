package org.haos.app.theme

import kotlinx.browser.document

actual fun setLocale(language: String) {
    val locale = when (language) {
        "ru" -> "ru"
        "en" -> "en"
        else -> "en"
    }
    document.documentElement?.setAttribute("lang", locale)
}