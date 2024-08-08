package org.haos.app.screens.wallet

import java.util.*


actual fun setLocale(language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    println("Locale set to $language for JVM")
}

internal actual fun connectTon(): String {
    println("ConnectTon for JVM")
    return ""
}