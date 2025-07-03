import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandler
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.TabConfig
import org.batuhanerdem.todoappcmp.root.DefaultAddEditComponent
import org.batuhanerdem.todoappcmp.root.DefaultHomeComponent
import org.batuhanerdem.todoappcmp.root.DefaultSettingsComponent


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
            DefaultSettingsComponent(componentContext)
        )
    }

    override fun onTabSelected(config: TabConfig) {
        navigation.bringToFront(config)
    }

}
