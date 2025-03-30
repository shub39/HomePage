package com.shub39.homepage.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shub39.homepage.BuildKonfig
import com.shub39.homepage.core.data.safeCall
import com.shub39.homepage.core.domain.DataError
import com.shub39.homepage.core.domain.LastFMData
import com.shub39.homepage.core.domain.Result
import com.shub39.homepage.core.presentation.randomColor
import com.shub39.homepage.homepage.HomePageAction
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val stateLayer: StateLayer,
    private val httpClient: HttpClient
) : ViewModel() {
    private val _state = stateLayer.homeState

    val state = _state.asStateFlow()
        .onStart { observeData() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _state.value
        )

    private fun observeData() = viewModelScope.launch {
        while (true) {
            val data: Result<LastFMData, DataError> = safeCall {
                httpClient.get("https://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=${BuildKonfig.USER}&limit=1&api_key=${BuildKonfig.API_KEY}&format=json")
            }

            when (data) {
                is Result.Error<DataError> -> {
                    _state.update {
                        it.copy(
                            currentData = null
                        )
                    }
                }

                is Result.Success<LastFMData> -> {
                    if (data.data != _state.value.currentData) {
                        _state.update {
                            it.copy(
                                currentData = data.data
                            )
                        }

                        _state.update {
                            it.copy(
                                seedColor = randomColor()
                            )
                        }
                    }
                }
            }

            delay(20000)
        }
    }

    fun onAction(action: HomePageAction) {
        viewModelScope.launch {
            when (action) {
                is HomePageAction.OnSearch -> {

                }
            }
        }
    }
}