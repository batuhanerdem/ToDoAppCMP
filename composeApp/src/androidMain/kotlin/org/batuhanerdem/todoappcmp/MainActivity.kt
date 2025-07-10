package org.batuhanerdem.todoappcmp

import RootComponentImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.retainedComponent
import org.batuhanerdem.todoappcmp.root.RootContent
import org.batuhanerdem.todoappcmp.ui.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val root = RootComponentImpl(componentContext = defaultComponentContext())
        setContent {
            RootContent(root)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}