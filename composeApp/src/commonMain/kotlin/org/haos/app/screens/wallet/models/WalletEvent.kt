package org.haos.app.screens.wallet.models

sealed class WalletEvent {
    data class Locale(val locale: String) : WalletEvent()
    data object ConnectTon : WalletEvent()
    data object DisconnectTon : WalletEvent()
}