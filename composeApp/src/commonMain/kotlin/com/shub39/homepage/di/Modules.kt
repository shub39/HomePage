package com.shub39.homepage.di

import com.shub39.homepage.core.data.HttpClientFactory
import com.shub39.homepage.viewmodels.HomePageViewModel
import com.shub39.homepage.viewmodels.StateLayer
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create() }

    singleOf(::StateLayer)
    singleOf(::HomePageViewModel)
}