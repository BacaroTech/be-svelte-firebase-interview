package mft.dev.configuration

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureFrameworks() {
    install(Koin) {
    }
}
