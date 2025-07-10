package org.batuhanerdem.todoappcmp.ui.home.add

import com.arkivanov.decompose.ComponentContext
import com.benasher44.uuid.uuid4
import org.batuhanerdem.todoappcmp.data.repository.ToDoRepository
import org.batuhanerdem.todoappcmp.model.ToDo
import org.koin.core.component.KoinComponent

class AddComponent(
    componentContext: ComponentContext,
    private val popBack: () -> Unit,
    private val repo: ToDoRepository
) : KoinComponent, ComponentContext by componentContext {
    fun addTodo(title: String) {
        val id = uuid4().toString()
        val newTodo = ToDo(id, title)
        repo.insertToDo(newTodo)
        val list = repo.getToDos()
        println("TESTING $list")
    }


    fun onPressPopBack() {
        popBack()
    }

}
