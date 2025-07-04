import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.TabConfig
import org.batuhanerdem.todoappcmp.ui.add_edit.DefaultAddEditComponent
import org.batuhanerdem.todoappcmp.ui.home.DefaultHomeComponent
import org.batuhanerdem.todoappcmp.ui.settings.DefaultSettingsComponent


class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<TabConfig>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = TabConfig.serializer(),
        initialConfiguration = TabConfig.Home,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    @OptIn(DelicateDecomposeApi::class)
    private fun createChild(
        config: TabConfig, componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        is TabConfig.Home -> RootComponent.Child.HomeChild(
            DefaultHomeComponent(componentContext)
        )

        is TabConfig.AddEdit -> RootComponent.Child.AddEditChild(
            DefaultAddEditComponent(componentContext)
        )

        is TabConfig.Settings -> RootComponent.Child.SettingsChild(
            DefaultSettingsComponent(componentContext, { navigation.bringToFront(TabConfig.Home) })
        )
    }

    override fun onTabSelected(config: TabConfig) {
        navigation.bringToFront(config)
    }

}
