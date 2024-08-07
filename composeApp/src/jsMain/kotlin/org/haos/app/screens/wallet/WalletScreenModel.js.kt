package org.haos.app.screens.wallet

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


internal actual fun connectTon() {
    println("ConnectTon for JVM")
    val script = """
    const tonConnectUI = new TON_CONNECT_UI.TonConnectUI({
        manifestUrl: 'https://https://exxuslee.github.io/Satoshi-Genesis/tonconnect-manifest.json'
    });

    tonConnectUI.uiOptions = {
        twaReturnUrl: 'https://https://exxuslee.github.io/Satoshi-Genesis',
    };

    tonConnectUI.openModal().then(() => {
        console.log('Modal opened');
    });
    """
//    js(script)

    val executor = JavaScriptExecutor()
    MainScope().launch {
        try {
            val result = executor.executeScript(script)
            println(result)
        } catch (e: UnsupportedOperationException) {
            println("JavaScript execution is not supported on this platform.")
        }
    }
}

