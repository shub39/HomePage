package com.shub39.homepage.homepage

sealed interface HomePageAction {
    data object OnRandomColors: HomePageAction
}