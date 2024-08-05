package org.haos.app.theme

actual fun setLocale(language: String) {
    val locale = when (language) {
        "ru" -> "ru-RU"
        "en" -> "en-US"
        else -> "en-US"
    }
    js("document.documentElement.lang = locale")
}