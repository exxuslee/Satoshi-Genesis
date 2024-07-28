package org.haos.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@Composable
internal fun App() {
    var selectedScreen by remember { mutableStateOf(ScreenGraph.entries.firstOrNull()) }
    return AppTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
                    ScreenGraph.entries.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(getIconForScreen(screen), contentDescription = screen.name) },
                            label = { Text(screen.name) },
                            selected = screen == selectedScreen,
                            onClick = { selectedScreen = screen },
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            },
            content = {
                when (selectedScreen) {
                    ScreenGraph.News -> Navigator(HomeScreen())
                    ScreenGraph.Search -> Navigator(ProfileScreen())
                    ScreenGraph.Saved -> Navigator(SearchNewsScreen())
                    ScreenGraph.Profile -> Navigator(SavedNewsListScreen())
                    null -> Navigator(HomeScreen())
                }
            }
        )
    }
}

@Composable
private fun getIconForScreen(screen: ScreenGraph) = when (screen) {
    ScreenGraph.News -> Icons.Default.Home
    ScreenGraph.Search -> Icons.Default.Search
    ScreenGraph.Saved -> Icons.Default.FavoriteBorder
    ScreenGraph.Profile -> Icons.Default.Menu
}