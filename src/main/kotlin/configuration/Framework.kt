package mft.dev.configuration

import io.ktor.server.application.*
import mft.dev.service.impl.EventService
import mft.dev.service.impl.PersonService
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureFrameworks() {
    install(Koin) {
        modules(
            module {
                single { PersonService() }
                single { EventService() }
            }
        )
    }
}
