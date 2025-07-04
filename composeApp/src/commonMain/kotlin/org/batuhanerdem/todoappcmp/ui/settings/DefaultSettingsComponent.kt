package org.batuhanerdem.todoappcmp.ui.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback

class DefaultSettingsComponent(
    componentContext: ComponentContext, goBackToHome: () -> Unit
) : ComponentContext by componentContext {
    init {
        val a = BackCallback { goBackToHome() }
        backHandler.register(a)
        print("test register: ${backHandler.isRegistered(a)}")
        a.isEnabled = true
        //doesn't work
    }

}