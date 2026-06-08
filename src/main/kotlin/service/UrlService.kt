package dev.drewboiii.service

import dev.drewboiii.dto.UrlCreateRequestDto
import dev.drewboiii.dto.UrlCreateResponseDto

class UrlService {

    suspend fun shortUrl(request: UrlCreateRequestDto): UrlCreateResponseDto {
        return UrlCreateResponseDto(
            shortUrl = request.url
        )
    }

}