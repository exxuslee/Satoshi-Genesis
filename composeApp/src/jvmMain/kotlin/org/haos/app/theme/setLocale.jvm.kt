package org.haos.app.theme

import java.util.*

actual fun setLocale(language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    println("Locale set to $language for JVM")
}