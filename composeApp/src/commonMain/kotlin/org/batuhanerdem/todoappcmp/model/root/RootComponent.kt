package org.batuhanerdem.todoappcmp.model.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.navigation.TabConfig
import org.batuhanerdem.todoappcmp.root.AddEditComponent
import org.batuhanerdem.todoappcmp.root.HomeComponent
import org.batuhanerdem.todoappcmp.root.SettingsComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onTabSelected(config: TabConfig)

    sealed interface Child {
        class HomeChild(val component: HomeComponent) : Child
        class AddEditChild(val component: AddEditComponent) : Child
        class SettingsChild(val component: SettingsComponent) : Child
    }
}
