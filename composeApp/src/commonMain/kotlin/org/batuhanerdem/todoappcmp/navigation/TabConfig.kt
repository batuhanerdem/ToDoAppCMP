package org.batuhanerdem.todoappcmp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class TabConfig  {
    @Serializable
    data object Home : TabConfig()

    @Serializable
    data object AddEdit : TabConfig()

    @Serializable
    data object Settings : TabConfig()
}