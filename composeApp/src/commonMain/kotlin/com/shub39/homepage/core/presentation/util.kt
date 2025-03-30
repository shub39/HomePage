package com.shub39.homepage.core.presentation

import androidx.compose.ui.graphics.Color
import com.materialkolor.ktx.darken
import com.materialkolor.ktx.lighten
import kotlin.random.Random

fun generateColorList(seedColor: Color = randomColor()): List<Color> {
    return listOf(
        seedColor.lighten(2.5f),
        seedColor.lighten(1.5f),
        seedColor,
        seedColor.darken(1.5f),
        seedColor.darken(2.5f)
    )
}

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}