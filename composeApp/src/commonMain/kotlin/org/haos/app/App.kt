package org.haos.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import org.haos.app.navigations.ScreenGraph
import org.haos.app.screens.PuzzleScreen
import org.haos.app.screens.QubitScreen
import org.haos.app.screens.SettingsScreen
import org.haos.app.screens.WalletScreen
import org.haos.app.theme.AppTheme
import org.haos.app.ui.caption_leah
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import satoshi_genesis.composeapp.generated.resources.*
import satoshi_genesis.composeapp.generated.resources.Res
import satoshi_genesis.composeapp.generated.resources.ic_account_balance_fill0
import satoshi_genesis.composeapp.generated.resources.ic_account_balance_fill1
import satoshi_genesis.composeapp.generated.resources.ic_sports_fill0
import satoshi_genesis.composeapp.generated.resources.ic_sports_fill1

@Composable
internal fun App() = AppTheme {
    var selectedScreen by remember { mutableStateOf(ScreenGraph.entries.first()) }
    Scaffold(
        bottomBar = {
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
                        label = { caption_leah(stringResource(screen.label)) },
                        selected = screen == selectedScreen,
                        onClick = { selectedScreen = screen },
                    )
                }
            }
        },
        content = {
            when (selectedScreen) {
                ScreenGraph.Wallet -> Navigator(WalletScreen())
                ScreenGraph.Puzzle -> Navigator(PuzzleScreen())
                ScreenGraph.Qubit -> Navigator(QubitScreen())
                ScreenGraph.Settings -> Navigator(SettingsScreen())
            }
        }
    )
}

@Composable
private fun getIconForScreen(screen: ScreenGraph, selected: Boolean) = if (selected) when (screen) {
    ScreenGraph.Wallet -> vectorResource(Res.drawable.ic_account_balance_fill1)
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill1)
    ScreenGraph.Qubit -> Icons.Rounded.Favorite
    ScreenGraph.Settings -> Icons.Rounded.Settings
} else when (screen) {
    ScreenGraph.Wallet -> vectorResource(Res.drawable.ic_account_balance_fill0)
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill0)
    ScreenGraph.Qubit -> Icons.Outlined.FavoriteBorder
    ScreenGraph.Settings -> Icons.Outlined.Settings
}
