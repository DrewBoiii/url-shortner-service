package dev.drewboiii.repository

class UrlRepository {

    val localStorage = LinkedHashMap<String, String>()

    suspend fun saveUrl(url: String, shortUrl: String): String {
        localStorage[shortUrl] = url
        return shortUrl
    }

    suspend fun getOriginalUrl(shortUrl: String): String? = localStorage[shortUrl]

    suspend fun getUrls(): Set<String> = localStorage.keys

}