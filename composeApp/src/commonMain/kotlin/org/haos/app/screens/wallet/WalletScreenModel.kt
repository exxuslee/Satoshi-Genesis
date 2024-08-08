package org.haos.app.screens.wallet

import org.haos.app.core.BaseScreenModel
import org.haos.app.screens.wallet.models.WalletAction
import org.haos.app.screens.wallet.models.WalletEvent
import org.haos.app.screens.wallet.models.WalletViewState


class WalletScreenModel :
    BaseScreenModel<WalletViewState, WalletAction, WalletEvent>(initialState = WalletViewState()) {
    override fun obtainEvent(viewEvent: WalletEvent) {
        when (viewEvent) {
            is WalletEvent.Locale -> {
                setLocale(viewEvent.locale)
                viewState = viewState.copy(locale = viewEvent.locale)
            }

            WalletEvent.ConnectTon -> {
                val address = connectTon()
                println("kmp $address")
            }
            WalletEvent.DisconnectTon -> {}
        }
    }

}

internal expect fun connectTon(): String
expect fun setLocale(language: String)