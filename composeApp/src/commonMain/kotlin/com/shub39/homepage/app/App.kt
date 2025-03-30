package com.shub39.homepage.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shub39.homepage.core.presentation.theme.provideTypography
import com.shub39.homepage.homepage.HomePage
import com.shub39.homepage.viewmodels.HomePageViewModel
import org.koin.compose.koinInject

@Composable
fun App(
    navController: NavHostController,
    homevm: HomePageViewModel = koinInject()
) {
    val homeState by homevm.state.collectAsStateWithLifecycle()

    MaterialTheme(
        typography = provideTypography(1f)
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            navController = navController,
            startDestination = Routes.Home
        ) {
            composable<Routes.Home> {
                HomePage(
                    state = homeState
                )
            }

            composable<Routes.Settings> {

            }
        }
    }
}