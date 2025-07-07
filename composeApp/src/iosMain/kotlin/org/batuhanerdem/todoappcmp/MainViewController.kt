package org.batuhanerdem.todoappcmp

import androidx.compose.ui.window.ComposeUIViewController
import org.batuhanerdem.todoappcmp.ui.App
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    App()
}