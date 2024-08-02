package org.haos.app.screens.wallet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.app.navigations.SlideTransition


@OptIn(ExperimentalVoyagerApi::class)
class WalletScreen : Screen , ScreenTransition by SlideTransition() {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { WalletScreenModel() }
        val viewState by screenModel.viewStates().collectAsState()
        val viewAction by screenModel.viewActions().collectAsState(null)


        WalletView(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }

        when (viewAction) {
            null -> {}
        }
    }

}