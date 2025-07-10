package org.batuhanerdem.todoappcmp.data.repository

import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase
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

    fun clearDB() {
        database.toDoAppCMPDatabaseQueries.clearDB()
    }

    fun updateToDo(todo: ToDo) {
        val isCheckedLong = if (todo.isSelected) 1L else 0L
        database.toDoAppCMPDatabaseQueries.updateToDo(todo.title, isCheckedLong, todo.id)
    }


    private fun mapToDos(id: String, title: String, isChecked: Long): ToDo {
        val isSelected = isChecked.toInt() == 1
        return ToDo(id, title, isSelected)
    }
}