package dev.drewboiii

import dev.drewboiii.service.UrlService
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

val koinModule = module {
    single { UrlService() }
}

fun Application.configureKoin() {
    install(Koin) {
        modules(koinModule)
    }
}
