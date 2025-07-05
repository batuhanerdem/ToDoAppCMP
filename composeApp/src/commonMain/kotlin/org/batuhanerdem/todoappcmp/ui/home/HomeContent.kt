package org.batuhanerdem.todoappcmp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.batuhanerdem.todoappcmp.model.ToDo


@Composable
fun HomeContent(component: DefaultHomeComponent) {
    Column(Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 30.dp)) {
        Spacer(
            modifier = Modifier.padding(top = 30.dp)
        )
        Text(
            "To-Do List", fontSize = 35.sp, color = Color.Black
        )
    }
    ToDoList(listOf())


}

@Composable
fun ToDoList(list: List<ToDo>) {

    LazyColumn() {
        items(list) { todo ->
            ToDoItem(todo)
        }
    }
}

@Composable
fun ToDoItem(todo: ToDo) {

}