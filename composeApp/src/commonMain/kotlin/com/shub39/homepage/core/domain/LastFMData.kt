package com.shub39.homepage.core.domain

import kotlinx.serialization.*

@Serializable
data class LastFMData (
    val recenttracks: RecentTracks
)

@Serializable
data class RecentTracks (
    val track: List<Track>
)

@Serializable
data class Track (
    val artist: Name,
    val image: List<Image>,
    val mbid: String,
    val album: Name,
    val name: String,
)

@Serializable
data class Name (
    val mbid: String,

    @SerialName("#text")
    val text: String
)

@Serializable
data class Image (
    val size: String,

    @SerialName("#text")
    val text: String
)