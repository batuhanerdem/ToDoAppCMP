package org.batuhanerdem.todoappcmp.model.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.navigation.TabConfig
import org.batuhanerdem.todoappcmp.ui.add_edit.DefaultAddEditComponent
import org.batuhanerdem.todoappcmp.ui.home.DefaultHomeComponent
import org.batuhanerdem.todoappcmp.ui.settings.DefaultSettingsComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onTabSelected(config: TabConfig)

    sealed interface Child {
        class HomeChild(val component: DefaultHomeComponent) : Child
        class AddEditChild(val component: DefaultAddEditComponent) : Child
        class SettingsChild(val component: DefaultSettingsComponent) : Child
    }
}
