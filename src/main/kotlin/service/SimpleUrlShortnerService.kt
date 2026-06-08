package dev.drewboiii.service

import java.util.*

class SimpleUrlShortnerService : UrlShortnerService {

    override suspend fun getShortUrl(url: String): String =
        UUID.randomUUID().toString().substring(0, 6)

}