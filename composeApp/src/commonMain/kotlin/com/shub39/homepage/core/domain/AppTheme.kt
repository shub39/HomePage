package com.shub39.homepage.core.domain

import homepage.composeapp.generated.resources.Res
import homepage.composeapp.generated.resources.dark
import homepage.composeapp.generated.resources.light
import homepage.composeapp.generated.resources.system
import org.jetbrains.compose.resources.StringResource

enum class AppTheme(val fullName: StringResource) {
    LIGHT(Res.string.light),
    DARK(Res.string.dark),
    SYSTEM(Res.string.system)
}