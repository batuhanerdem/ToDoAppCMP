package org.batuhanerdem.todoappcmp.ui

import RootComponentImpl
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.batuhanerdem.todoappcmp.root.RootContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val root =
        RootComponentImpl(componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()))
    MaterialTheme {
        RootContent(root)
    }
}