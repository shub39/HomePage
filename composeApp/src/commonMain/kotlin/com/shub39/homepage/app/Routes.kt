package com.shub39.homepage.app

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Home: Routes

    @Serializable
    data object Settings: Routes
}