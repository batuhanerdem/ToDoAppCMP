package org.batuhanerdem.todoappcmp.model.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.HomeComponent
import org.batuhanerdem.todoappcmp.ui.home.add.AddComponent
import org.batuhanerdem.todoappcmp.ui.settings.SettingsComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onTabSelected(config: Config)

    sealed interface Child {
        class HomeChild(val component: HomeComponent) : Child
        class SettingsChild(val component: SettingsComponent) : Child
        class AddChild(val component: AddComponent) : Child
    }
}
