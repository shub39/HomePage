package com.shub39.homepage

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.rememberNavController
import com.shub39.homepage.app.App
import com.shub39.homepage.di.initKoin
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    initKoin()

    ComposeViewport(document.body!!) {
        val navcontroller = rememberNavController()

        App(navcontroller)

        LaunchedEffect(Unit) {
            window.bindToNavigation(
                navcontroller = navcontroller,
                getBackStackEntryRoute = { it.destination.route?.split(".")?.lastOrNull() ?: "" }
            )
        }
    }
}