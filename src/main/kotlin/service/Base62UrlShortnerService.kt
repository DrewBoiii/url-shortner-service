package dev.drewboiii.service

import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.incrementAndFetch

@OptIn(ExperimentalAtomicApi::class)
class Base62UrlShortnerService : UrlShortnerService {

    private val counter = AtomicLong(1_000_000L)

    override suspend fun getShortUrl(url: String): String =
        encodeToBase62(counter.incrementAndFetch())

    private fun encodeToBase62(id: Long): String {
        var number = id
        val sb = StringBuilder()
        while (number > 0) {
            sb.append(BASE_62_CHARACTERS[(number % BASE_62_NUMBER).toInt()])
            number /= BASE_62_NUMBER
        }
        return sb.reversed().toString()
    }

    companion object {
        const val BASE_62_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        const val BASE_62_NUMBER = 62
    }
}