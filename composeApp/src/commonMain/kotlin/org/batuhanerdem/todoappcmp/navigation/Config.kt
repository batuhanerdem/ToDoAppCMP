package org.batuhanerdem.todoappcmp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Config {
    @Serializable
    data object Home : Config()

    @Serializable
    data object Add : Config()

    @Serializable
    data object Settings : Config()
}