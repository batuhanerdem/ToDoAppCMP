package org.batuhanerdem.todoappcmp.ui.home.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddContent(component: AddComponent) {
    BackButton(component)

    Column(Modifier.padding(horizontal = 15.dp)) {
        AddToDoText()

        var todoTitle by remember { mutableStateOf("") }

        Spacer(Modifier.padding(top = 15.dp))

        OutlinedTextField(
            value = todoTitle,
            onValueChange = { todoTitle = it },
            label = { Text("Todo Title") },
            placeholder = { Text("Enter title") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            shape = RoundedCornerShape(12.dp)
        )

        Button(
            onClick = { component.addTodo(todoTitle) },
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            content = {
                Text("Save")
            })

    }
}


@Composable
fun AddToDoText() {
    Column(modifier = Modifier) {
        Text(
            "Add To-Do",
            fontSize = 35.sp,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 25.dp)
        )
    }
}

@Composable
fun BackButton(component: AddComponent) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            onClick = { component.onPressPopBack() }, colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Black
            ), content = {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back"
                )
            })
    }
}
