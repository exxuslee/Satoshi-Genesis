package org.haos.app.theme

import kotlinx.browser.document
import kotlinx.dom.clear
import org.w3c.dom.HTMLCanvasElement

actual fun setLocale(language: String) {
    val locale = when (language) {
        "ru" -> "ru"
        "en" -> "en"
        else -> "en"
    }
    document.documentElement?.setAttribute("lang", locale)
    val asd= document.getElementById("ComposeTarget")
    (asd as HTMLCanvasElement).clear()
}