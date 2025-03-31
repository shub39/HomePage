package com.shub39.homepage.homepage

sealed interface HomePageAction {
    data object OnRandomColors: HomePageAction
    data class OnChangeUsername(val name: String): HomePageAction
}