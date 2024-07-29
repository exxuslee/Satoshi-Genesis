package org.haos.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import org.haos.app.navigations.ScreenGraph
import org.haos.app.screens.HomeScreen
import org.haos.app.screens.ProfileScreen
import org.haos.app.screens.SavedNewsListScreen
import org.haos.app.screens.SearchNewsScreen
import org.haos.app.theme.AppTheme
import org.haos.app.ui.caption_leah
import org.jetbrains.compose.resources.vectorResource
import satoshi_genesis.composeapp.generated.resources.*

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
                        label = { caption_leah(screen.name) },
                        selected = screen == selectedScreen,
                        onClick = { selectedScreen = screen },
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        },
        content = {
            when (selectedScreen) {
                ScreenGraph.Home -> Navigator(HomeScreen())
                ScreenGraph.Puzzle -> Navigator(ProfileScreen())
                ScreenGraph.Saved -> Navigator(SearchNewsScreen())
                ScreenGraph.Settings -> Navigator(SavedNewsListScreen())
            }
        }
    )
}

@Composable
private fun getIconForScreen(screen: ScreenGraph, selected: Boolean) = if (selected) when (screen) {
    ScreenGraph.Home -> vectorResource(Res.drawable.ic_account_balance_fill1)
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill1)
    ScreenGraph.Saved -> Icons.Rounded.FavoriteBorder
    ScreenGraph.Settings -> Icons.Rounded.Settings
} else when (screen) {
    ScreenGraph.Home -> vectorResource(Res.drawable.ic_account_balance_fill0)
    ScreenGraph.Puzzle -> vectorResource(Res.drawable.ic_sports_fill0)
    ScreenGraph.Saved -> Icons.Outlined.FavoriteBorder
    ScreenGraph.Settings -> Icons.Outlined.Settings
}