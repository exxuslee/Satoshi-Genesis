package org.haos.app.screens.wallet

expect class JavaScriptExecutor {
    suspend fun executeScript(script: String): dynamic
}