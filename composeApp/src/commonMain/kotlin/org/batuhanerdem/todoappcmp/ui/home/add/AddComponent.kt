package org.batuhanerdem.todoappcmp.ui.home.add

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.batuhanerdem.todoappcmp.model.ToDo
import kotlin.coroutines.CoroutineContext


class AddComponent(
    componentContext: ComponentContext,
    private val popBack: () -> Unit
) :
    ComponentContext by componentContext {
    fun addTodo(title: String) {
        val id = "add id generator later"
        val newTodo = ToDo(id, title)
        // add todo
    }

    private val scope = coroutineScope(Dispatchers.Main)


    init {
        scope.launch {
            delay(4000)
            popBack()
        }
    }

    fun onPressPopBack() {
        popBack()
    }

}
