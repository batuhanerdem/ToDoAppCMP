package org.batuhanerdem.todoappcmp.ui.home.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddContent(component: AddComponent) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 30.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        // back button
    }
    Column(modifier = Modifier) {
        Text(
            "Add To-Do", fontSize = 35.sp, color = Color.Black
        )
    }



}