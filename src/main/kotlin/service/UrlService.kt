package dev.drewboiii.service

import dev.drewboiii.dto.UrlCreateRequestDto
import dev.drewboiii.dto.UrlCreateResponseDto
import dev.drewboiii.dto.UrlsResponseDto
import dev.drewboiii.repository.UrlRepository

class UrlService(
    private val urlRepository: UrlRepository,
    private val urlShortnerService: UrlShortnerService,
) {

    suspend fun buildShortUrl(request: UrlCreateRequestDto): UrlCreateResponseDto {
        val shortUrl = urlRepository.saveUrl(
            url = request.url,
            shortUrl = urlShortnerService.getShortUrl(request.url)
        )

        return UrlCreateResponseDto(
            shortUrl = shortUrl
        )
    }

    suspend fun getOriginalUrl(shortUrl: String): String? {
        return urlRepository.getOriginalUrl(shortUrl)
    }

    suspend fun getAll(): UrlsResponseDto {
        return UrlsResponseDto(
            urls = urlRepository.getUrls()
        )
    }

}