package org.batuhanerdem.todoappcmp.model.root

import org.batuhanerdem.todoappcmp.ui.home.DefaultHomeComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.add.AddComponent
import org.batuhanerdem.todoappcmp.ui.settings.DefaultSettingsComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onTabSelected(config: Config)

    sealed interface Child {
        class HomeChild(val component: DefaultHomeComponent) : Child
        class SettingsChild(val component: DefaultSettingsComponent) : Child
        class AddChild(val component: AddComponent) : Child
    }
}
