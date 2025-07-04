package org.batuhanerdem.todoappcmp.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SettingsContent(component: DefaultSettingsComponent) {
    Column(Modifier.fillMaxSize().padding(30.dp)) {

        Text("setme", fontSize = 30.sp)

    }
}