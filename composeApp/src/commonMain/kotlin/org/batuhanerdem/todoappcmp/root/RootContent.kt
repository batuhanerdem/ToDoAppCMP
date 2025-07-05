package org.batuhanerdem.todoappcmp.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.HomeContent
import org.batuhanerdem.todoappcmp.ui.home.add.AddContent
import org.batuhanerdem.todoappcmp.ui.settings.SettingsContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RootContent(component: RootComponent?) {
    if (component == null) return
    val stack by component.stack.subscribeAsState()

    Scaffold(topBar = {}, bottomBar = {
        BottomNavigationBar(
            selected = when (stack.active.instance) {
                is RootComponent.Child.HomeChild -> Config.Home
                is RootComponent.Child.SettingsChild -> Config.Settings
                is RootComponent.Child.AddChild -> Config.Add
            }, onTabSelected = component::onTabSelected
        )
    }) { padding ->
        Box(Modifier.fillMaxSize().background(Color.White)) {
            when (val child = stack.active.instance) {
                is RootComponent.Child.HomeChild -> HomeContent(child.component)
                is RootComponent.Child.SettingsChild -> SettingsContent(child.component)
                is RootComponent.Child.AddChild -> AddContent(child.component)
            }
        }
    }
}


@Composable
fun BottomNavigationBar(
    selected: Config, onTabSelected: (Config) -> Unit
) {
    if (selected == Config.Add) return
    val itemColors = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent,
        selectedIconColor = Color.Black,
        selectedTextColor = Color.Black,
        unselectedIconColor = Color.Gray,
        unselectedTextColor = Color.Gray
    )

    BottomAppBar(
        containerColor = Color.Transparent, modifier = Modifier.fillMaxHeight(0.15f)
    ) {
        NavigationBarItem(
            selected = selected is Config.Home,
            colors = itemColors,
            onClick = { onTabSelected(Config.Home) },
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(0.45f)
                )
            },
            label = { })
        NavigationBarItem(
            selected = selected is Config.Settings,
            colors = itemColors,
            onClick = { onTabSelected(Config.Settings) },
            icon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier.fillMaxSize(0.45f)
                )
            },
            label = { })
    }

}

@Preview
@Composable
fun PreviewRootContent() {
    RootContent(null)
}

