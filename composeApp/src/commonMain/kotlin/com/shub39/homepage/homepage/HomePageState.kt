package com.shub39.homepage.homepage

import androidx.compose.ui.graphics.Color
import com.shub39.homepage.core.domain.LastFMData
import com.shub39.homepage.core.presentation.randomColor

data class HomePageState(
    val seedColor: Color = randomColor(),
    val meshSpeed: Float = 3f,
    val currentData: LastFMData? = null
)
