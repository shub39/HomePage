package com.shub39.homepage

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.shub39.homepage.app.App
import com.shub39.homepage.di.initKoin
import org.jetbrains.compose.reload.DevelopmentEntryPoint

fun main() {
    initKoin()

    singleWindowApplication(
        alwaysOnTop = true,
        title = "Hot Reload",
        state = WindowState(height = 800.dp, width = 800.dp)
    ) {
        DevelopmentEntryPoint {
            App()
        }
    }
}