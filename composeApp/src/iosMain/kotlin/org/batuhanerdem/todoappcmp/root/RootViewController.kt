package org.batuhanerdem.todoappcmp.root

import androidx.compose.ui.window.ComposeUIViewController
import org.batuhanerdem.todoappcmp.model.root.RootComponent
import platform.UIKit.UIViewController

fun rootViewController(root: RootComponent): UIViewController =
    ComposeUIViewController() {
        RootContent(component = root)
    }
