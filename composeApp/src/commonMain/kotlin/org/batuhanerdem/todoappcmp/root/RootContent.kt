package org.batuhanerdem.todoappcmp.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kotlinx.coroutines.launch
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.HomeContent
import org.batuhanerdem.todoappcmp.ui.home.add.AddContent
import org.batuhanerdem.todoappcmp.ui.settings.SettingsContent

@Composable
fun RootContent(component: RootComponent) {
    val stack by component.stack.subscribeAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(bottomBar = {
        BottomNavigationBar(
            selected = when (stack.active.instance) {
                is RootComponent.Child.HomeChild -> Config.Home
                is RootComponent.Child.SettingsChild -> Config.Settings
                is RootComponent.Child.AddChild -> Config.Add
            }, onTabSelected = component::onTabSelected
        )
    }, snackbarHost = {
        SnackbarHost(snackbarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = Color.White,
                contentColor = Color.Black,
                actionColor = Color.Cyan,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(16.dp)
            )
        }
    }) { padding ->
        Box(Modifier.fillMaxSize().background(Color.White)) {
            when (val child = stack.active.instance) {
                is RootComponent.Child.HomeChild -> HomeContent(child.component)
                is RootComponent.Child.SettingsChild -> SettingsContent(child.component)
                is RootComponent.Child.AddChild -> AddContent(child.component, onToDoSaved = {
                    scope.launch {
                        snackbarHostState.showSnackbar("To-Do saved!")
                    }
                }, onToDoIsBlank = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Please enter the title")
                    }
                })
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
        containerColor = Color.White, modifier = Modifier.fillMaxHeight(0.15f).drawBehind {
            drawLine(
                color = Color.LightGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 1.dp.toPx()
            )
        }) {
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
