package dev.drewboiii.dto

import kotlinx.serialization.Serializable

@Serializable
data class UrlCreateRequestDto(
    val url: String
)

@Serializable
data class UrlCreateResponseDto(
    val shortUrl: String
)

@Serializable
data class UrlsResponseDto(
    val urls: Set<String>
)
