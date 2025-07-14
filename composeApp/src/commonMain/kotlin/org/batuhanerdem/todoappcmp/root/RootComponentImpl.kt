import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import org.batuhanerdem.todoappcmp.navigation.Config
import org.batuhanerdem.todoappcmp.ui.home.HomeComponent
import org.batuhanerdem.todoappcmp.ui.home.add.AddComponent
import org.batuhanerdem.todoappcmp.ui.settings.SettingsComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.get


class RootComponentImpl(
    componentContext: ComponentContext
) : KoinComponent, RootComponent, ComponentContext by componentContext {

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
    ): RootComponent.Child {

        return when (config) {
            is Config.Home -> RootComponent.Child.HomeChild(
                HomeComponent(componentContext, { navigation.bringToFront(Config.Add) }, get())
            )

            is Config.Add -> RootComponent.Child.AddChild(
                AddComponent(
                    componentContext, popBack = { navigation.pop() }, get()
                )
            )

            is Config.Settings -> RootComponent.Child.SettingsChild(
                SettingsComponent(
                    componentContext
                )
            )
        }
    }

    override fun onTabSelected(config: Config) {
        navigation.bringToFront(config)

    }

}
