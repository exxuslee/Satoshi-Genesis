package org.haos.app

import androidx.compose.animation.Crossfade
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.haos.app.navigations.ScreenGraph
import org.haos.app.screens.home.HomeScreen
import org.haos.app.screens.puzzle.PuzzleScreen
import org.haos.app.screens.wallet.WalletScreen
import org.haos.app.theme.AppTheme
import org.haos.app.ui.caption_leah
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import satoshi_genesis.composeapp.generated.resources.*

@Composable
internal fun App() = AppTheme {
    var selectedScreen by remember { mutableStateOf(ScreenGraph.entries.first()) }

    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.surface) {
            ScreenGraph.entries.forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        Crossfade(targetState = selectedScreen == screen) { isSelected ->
                            Icon(
                                getIconForScreen(screen, isSelected),
                                contentDescription = screen.name,
                            )
                        }
                    },
                    label = { caption_leah(text = stringResource(screen.label), maxLines = 1) },
                    selected = screen == selectedScreen,
                    onClick = { selectedScreen = screen },
                )
            }
        }
    }, content = {
        when (selectedScreen) {
            ScreenGraph.Home -> Navigator(HomeScreen())
            ScreenGraph.Puzzle -> Navigator(PuzzleScreen())
            ScreenGraph.Wallet -> Navigator(WalletScreen())
        }
    })
}

@Composable
private fun getIconForScreen(screen: ScreenGraph, selected: Boolean) = if (selected) when (screen) {
    ScreenGraph.Home -> Icons.Rounded.Home
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill1)
    ScreenGraph.Wallet -> vectorResource(Res.drawable.ic_account_balance_fill1)
} else when (screen) {
    ScreenGraph.Home -> Icons.Outlined.Home
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill0)
    ScreenGraph.Wallet -> vectorResource(Res.drawable.ic_account_balance_fill0)
}
