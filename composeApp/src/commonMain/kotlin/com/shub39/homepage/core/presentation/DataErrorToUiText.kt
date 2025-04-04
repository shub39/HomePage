package com.shub39.homepage.core.presentation

import com.shub39.homepage.core.domain.DataError
import homepage.composeapp.generated.resources.Res
import homepage.composeapp.generated.resources.no_internet
import homepage.composeapp.generated.resources.no_results
import homepage.composeapp.generated.resources.server_error
import homepage.composeapp.generated.resources.too_many_requests
import homepage.composeapp.generated.resources.unknown

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.too_many_requests
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.no_internet
        DataError.Remote.SERVER -> Res.string.server_error
        DataError.Remote.SERIALIZATION -> Res.string.unknown
        DataError.Remote.UNKNOWN -> Res.string.unknown
        DataError.Remote.NO_RESULTS -> Res.string.no_results
    }

    return UiText.StringResourceId(stringRes)
}