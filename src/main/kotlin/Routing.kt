package dev.drewboiii

import dev.drewboiii.dto.UrlCreateRequestDto
import dev.drewboiii.service.UrlService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val urlService: UrlService by inject()

    routing {
        post("/links") {
            val request = call.receive<UrlCreateRequestDto>()
            val response = urlService.buildShortUrl(request)
            call.respond(HttpStatusCode.Created, response)
        }

        get("/links") {
            val response = urlService.getAll()
            call.respond(HttpStatusCode.OK, response)
        }

        get("/redirect/{shortUrl}") {
            val shortUrl = call.pathParameters["shortUrl"] ?: throw IllegalArgumentException("ShortUrl cannot be null")

            val originalUrl = urlService.getOriginalUrl(shortUrl)

            if (originalUrl == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }

            call.respondRedirect(originalUrl, permanent = false)
        }

        get("/stats/{shortUrl}") {
            throw NotImplementedError("stats not implemented")
        }
    }
}
