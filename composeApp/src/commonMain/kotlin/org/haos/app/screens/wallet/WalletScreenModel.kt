package org.haos.app.screens.wallet

import org.haos.app.core.BaseScreenModel
import org.haos.app.screens.wallet.models.WalletAction
import org.haos.app.screens.wallet.models.WalletEvent
import org.haos.app.screens.wallet.models.WalletViewState
import org.haos.app.theme.setLocale


class WalletScreenModel :
    BaseScreenModel<WalletViewState, WalletAction, WalletEvent>(initialState = WalletViewState()) {
    override fun obtainEvent(viewEvent: WalletEvent) {
        when (viewEvent) {
            is WalletEvent.Locale -> {
                setLocale(viewEvent.locale)
                viewState = viewState.copy(locale = viewEvent.locale)
            }
        }
    }

}