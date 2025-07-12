package org.batuhanerdem.todoappcmp.ui.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.Lifecycle
import org.batuhanerdem.todoappcmp.data.repository.ToDoRepository
import org.batuhanerdem.todoappcmp.model.ToDo

class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val onPressAddButton: () -> Unit,
    private val repo: ToDoRepository
) : ComponentContext by componentContext {

    private val _todos = MutableValue<MutableList<ToDo>>(mutableListOf())
    val todos: Value<List<ToDo>> get() = _todos

    init {
        lifecycle.subscribe(object : Lifecycle.Callbacks {
            override fun onResume() {
                println("HomeComponent resumed")
                _todos.value.clear()
                _todos.value = repo.getToDos().toMutableList()
                println("compoentn ${todos.value}")
            }
        })
    }

    fun toggleTodoSelection(id: String) {
        _todos.value = _todos.value.map {
            if (it.id == id) {
                val newToDo = it.copy(isSelected = !it.isSelected)
                repo.updateToDo(newToDo)
                newToDo
            } else it
        }.toMutableList()
    }

    fun deleteToDo(toDo: ToDo) {
        repo.deleteToDo(toDo.id)
//        _todos.value.remove(toDo)
//        _todos.value = _todos.value.toMutableList()
        repo.deleteToDo(toDo.id)
        _todos.value = _todos.value.filter { it.id != toDo.id }.toMutableList()

    }

    fun onAddButtonPressed() {
        onPressAddButton()
    }
}
