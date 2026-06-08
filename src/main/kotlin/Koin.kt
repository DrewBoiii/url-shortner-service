package dev.drewboiii

import dev.drewboiii.repository.UrlRepository
import dev.drewboiii.service.SimpleUrlShortnerService
import dev.drewboiii.service.UrlService
import dev.drewboiii.service.UrlShortnerService
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

val koinModule = module {
    single { UrlRepository() }
    single<UrlShortnerService> { SimpleUrlShortnerService() }
    single { UrlService(get(), get()) }
}

fun Application.configureKoin() {
    install(Koin) {
        modules(koinModule)
    }
}
