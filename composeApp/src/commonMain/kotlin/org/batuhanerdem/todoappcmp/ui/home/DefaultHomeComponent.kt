package org.batuhanerdem.todoappcmp.ui.home

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val onPressAddButton: () -> Unit
) :
    ComponentContext by componentContext {
    fun onAddButtonPressed() {
        onPressAddButton()
    }
}
