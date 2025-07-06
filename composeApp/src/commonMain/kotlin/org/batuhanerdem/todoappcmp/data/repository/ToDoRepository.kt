package org.batuhanerdem.todoappcmp.data.repository

import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase
import org.batuhanerdem.todoappcmp.data.db.DatabaseDriverFactory
import org.batuhanerdem.todoappcmp.model.ToDo


class ToDoRepository(private val database: ToDoAppCMPDatabase) {

    fun getToDos(): List<ToDo> =
        database.toDoAppCMPDatabaseQueries.selectAllToDos(::mapToDos).executeAsList()

    fun insertToDo(toDo: ToDo) {
        val int = if (toDo.isSelected) 1 else 2
        database.toDoAppCMPDatabaseQueries.insertToDo(toDo.id, toDo.title, int.toLong())
    }

    fun deleteToDo(id: String) {
        database.toDoAppCMPDatabaseQueries.deleteToDo(id)
    }


    private fun mapToDos(id: String, title: String, isChecked: Long): ToDo {
        val isSelected = isChecked.toInt() == 1
        return ToDo(id, title, isSelected)
    }
}