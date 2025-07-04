package org.batuhanerdem.todoappcmp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
        Box(Modifier.fillMaxSize()) {
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
    NavigationBar {
        NavigationBarItem(
            selected = selected is TabConfig.Home,
            onClick = { onTabSelected(TabConfig.Home) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") })
        NavigationBarItem(
            selected = selected is TabConfig.AddEdit,
            onClick = { onTabSelected(TabConfig.AddEdit) },
            icon = { Icon(Icons.Filled.Edit, contentDescription = "Add/Edit") },
            label = { Text("Add/Edit") })
        NavigationBarItem(
            selected = selected is TabConfig.Settings,
            onClick = { onTabSelected(TabConfig.Settings) },
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text("Settings") })
    }
}


