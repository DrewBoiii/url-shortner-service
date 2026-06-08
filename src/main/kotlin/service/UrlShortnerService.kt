package dev.drewboiii.service

import io.ktor.http.Url

interface UrlShortnerService {

    suspend fun getShortUrl(url: String): String

}