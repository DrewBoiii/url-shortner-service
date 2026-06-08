package dev.drewboiii

import dev.drewboiii.dto.UrlCreateRequestDto
import dev.drewboiii.service.UrlService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val urlService: UrlService by inject()

    routing {
        get("/") {
            call.respondText("Hello, World!")
        }

        post("/links") {
            val request = call.receive<UrlCreateRequestDto>()
            val response = urlService.shortUrl(request)
            call.respond(HttpStatusCode.Created, response)
        }
    }
}
