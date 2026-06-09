package dev.drewboiii

import dev.drewboiii.repository.UrlRepository
import dev.drewboiii.service.Base62UrlShortnerService
import dev.drewboiii.service.SimpleUrlShortnerService
import dev.drewboiii.service.UrlService
import dev.drewboiii.service.UrlShortnerService
import io.ktor.server.application.*
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

val koinModule = module {
    single { UrlRepository() }
    single<UrlShortnerService>(named("simpleUrlShortner")) { SimpleUrlShortnerService() }
    single<UrlShortnerService>(named("base62UrlShortner")) { Base62UrlShortnerService() }
    single { UrlService(get(), get(named("base62UrlShortner"))) }
}

fun Application.configureKoin() {
    install(Koin) {
        modules(koinModule)
    }
}
