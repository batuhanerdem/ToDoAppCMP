import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.DefaultHomeComponent
import org.batuhanerdem.todoappcmp.ui.home.add.AddComponent
import org.batuhanerdem.todoappcmp.ui.settings.DefaultSettingsComponent


class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Home,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    @OptIn(DelicateDecomposeApi::class)
    private fun createChild(
        config: Config, componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        is Config.Home -> RootComponent.Child.HomeChild(
            DefaultHomeComponent(componentContext, { navigation.pushNew(Config.Add) })
        )

        is Config.Add -> RootComponent.Child.AddChild(
            AddComponent(
                componentContext,
                popBack = { navigation.pop() },
            )
        )

        is Config.Settings -> RootComponent.Child.SettingsChild(
            DefaultSettingsComponent(
                componentContext, { navigation.bringToFront(Config.Home) })
        )
    }

    override fun onTabSelected(config: Config) {
        navigation.bringToFront(config)
    }

}
