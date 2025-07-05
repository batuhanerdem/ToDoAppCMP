package org.batuhanerdem.todoappcmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
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
import org.batuhanerdem.todoappcmp.navigation.TabConfig
import org.batuhanerdem.todoappcmp.ui.add_edit.AddEditContent
import org.batuhanerdem.todoappcmp.ui.home.HomeContent
import org.batuhanerdem.todoappcmp.ui.settings.SettingsContent

@Composable
fun RootContent(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selected = when (stack.active.instance) {
                    is RootComponent.Child.HomeChild -> TabConfig.Home
                    is RootComponent.Child.AddEditChild -> TabConfig.AddEdit
                    is RootComponent.Child.SettingsChild -> TabConfig.Settings
                }, onTabSelected = component::onTabSelected
            )
        }) { padding ->
        Box(Modifier.fillMaxSize().background(Color.White)) {
            when (val child = stack.active.instance) {
                is RootComponent.Child.HomeChild -> HomeContent(child.component)
                is RootComponent.Child.AddEditChild -> AddEditContent(child.component)
                is RootComponent.Child.SettingsChild -> SettingsContent(child.component)
            }
        }
    }
}


@Composable
fun BottomNavigationBar(
    selected: TabConfig, onTabSelected: (TabConfig) -> Unit
) {
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
            selected = selected is TabConfig.Home,
            colors = itemColors,
            onClick = { onTabSelected(TabConfig.Home) },
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(0.45f)
                )
            },
            label = { })
        NavigationBarItem(
            selected = selected is TabConfig.AddEdit,
            colors = itemColors,
            onClick = { onTabSelected(TabConfig.AddEdit) },
            icon = {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Add/Edit",
                    modifier = Modifier.fillMaxSize(0.45f)

                )
            },
            label = { })
        NavigationBarItem(
            selected = selected is TabConfig.Settings,
            colors = itemColors,
            onClick = { onTabSelected(TabConfig.Settings) },
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


