package dev.drewboiii.service

interface UrlShortnerService {

    suspend fun getShortUrl(url: String): String

}