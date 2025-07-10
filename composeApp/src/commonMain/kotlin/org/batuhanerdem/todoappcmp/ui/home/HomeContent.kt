package org.batuhanerdem.todoappcmp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.batuhanerdem.todoappcmp.model.ToDo

@Composable
fun HomeContent(component: DefaultHomeComponent) {
    val todos = component.todos.subscribeAsState()
    Column(
        Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 30.dp)
    ) {
        println("compose ${todos.value}")
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Button(onClick = component::onAddButtonPressed) {
                Text("+") // Replace with icon if needed
            }
            Button(onClick = { /* Edit mode toggle logic here */ }) {
                Text("Edit")
            }
        }

        Spacer(Modifier.padding(top = 30.dp))

        Text("To-Do List", fontSize = 35.sp, color = Color.Black)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(todos.value, key = { it.id }) { todo ->
                ToDoItem(todo = todo, onToggle = { component.toggleTodoSelection(todo.id) })
            }

        }
    }
}

@Composable
fun ToDoItem(todo: ToDo, onToggle: () -> Unit) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth().background(Color.Yellow),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.isSelected, onCheckedChange = { onToggle() })
        Text(text = todo.title)
    }
}
