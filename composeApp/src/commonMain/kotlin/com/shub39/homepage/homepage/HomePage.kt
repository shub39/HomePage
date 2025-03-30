package com.shub39.homepage.homepage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient

@Composable
fun HomePage(
    state: HomePageState
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .shaderBackground(
                MeshGradient(
                    colors = state.shaderColors.toTypedArray()
                )
            ),
        color = Color.Transparent
    ) {

    }
}