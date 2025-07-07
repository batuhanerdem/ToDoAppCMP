package org.batuhanerdem.todoappcmp.ui.home.add

import com.arkivanov.decompose.ComponentContext
import org.batuhanerdem.todoappcmp.data.repository.ToDoRepository
import org.batuhanerdem.todoappcmp.model.ToDo


class AddComponent(
    componentContext: ComponentContext,
    private val popBack: () -> Unit,
    private val repo: ToDoRepository
) :
    ComponentContext by componentContext {
    fun addTodo(title: String) {
        val id = "add id generator later"
        val newTodo = ToDo(id, title)
        repo.insertToDo(newTodo)
        val list = repo.getToDos()
        print(list)
    }

    fun onPressPopBack() {
        popBack()
    }

}
