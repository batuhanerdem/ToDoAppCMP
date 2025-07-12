package org.batuhanerdem.todoappcmp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.batuhanerdem.todoappcmp.model.ToDo

@Composable
fun HomeContent(component: HomeComponent) {
    val todos = component.todos.subscribeAsState()
    var isEditMode by remember { mutableStateOf(false) }
    Column {
        Spacer(Modifier.padding(top = 30.dp))
        Buttons(component, isEditMode, {
            isEditMode = !isEditMode
        })
        Column(
            Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.Top
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                item {
                    Text(
                        text = "To-Do List",
                        fontSize = 35.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                items(todos.value, key = { it.id }) { todo ->
                    ToDoItem(
                        todo = todo,
                        onToggle = { component.toggleTodoSelection(todo.id) },
                        onDelete = { component.deleteToDo(todo) },
                        isEditMode
                    )
                }
                item {
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Spacer(modifier = Modifier.fillMaxHeight(0.15f))
                }

            }
        }
    }
}

@Composable
fun ToDoItem(todo: ToDo, onToggle: () -> Unit, onDelete: () -> Unit, isEditMode: Boolean) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = todo.isSelected, onCheckedChange = { onToggle() })
            Text(
                text = todo.title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }
        if (isEditMode) Button(
            onClick = { onDelete() },
            content = { Icon(Icons.Default.Delete, "") },
            contentPadding = PaddingValues(0.dp),
            colors = buttonColors
        )
    }
}

@Composable
fun Buttons(component: HomeComponent, isEditMode: Boolean, editOnClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Button(
            onClick = component::onAddButtonPressed,
            colors = buttonColors,
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "add",
                tint = Color.Black,
                modifier = Modifier.height(35.dp).width(35.dp)
            )
        }

        Button(onClick = {
            editOnClick()
        }, colors = buttonColors) {
            Text(
                if (!isEditMode) "Edit" else "Cancel",
                fontSize = 21.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

val buttonColors = ButtonColors(
    containerColor = Color.Transparent,
    contentColor = Color.Black,
    disabledContentColor = Color.Transparent,
    disabledContainerColor = Color.Transparent
)
