package org.haos.app.screens.wallet

actual class JavaScriptExecutor {
    actual suspend fun executeScript(script: String): dynamic {
        return eval(script)
    }
}