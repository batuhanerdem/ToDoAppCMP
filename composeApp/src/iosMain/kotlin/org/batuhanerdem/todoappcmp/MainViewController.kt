package org.batuhanerdem.todoappcmp

import androidx.compose.ui.window.ComposeUIViewController
import org.batuhanerdem.todoappcmp.di.initKoin
import org.batuhanerdem.todoappcmp.ui.App

fun MainViewController() = ComposeUIViewController(configure = {  }) { App() }