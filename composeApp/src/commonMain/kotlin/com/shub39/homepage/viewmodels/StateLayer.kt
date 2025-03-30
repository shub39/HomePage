package com.shub39.homepage.viewmodels

import com.shub39.homepage.homepage.HomePageState
import kotlinx.coroutines.flow.MutableStateFlow

class StateLayer {
    val homeState = MutableStateFlow(HomePageState())
}