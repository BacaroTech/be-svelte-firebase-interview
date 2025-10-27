package mft.dev

import io.ktor.server.application.*
import mft.dev.configuration.configureDatabases
import mft.dev.configuration.configureFrameworks
import mft.dev.configuration.configureSerialization
import mft.dev.routing.configureEventRouting
import mft.dev.routing.configurePersonRouting

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabases()
    configureFrameworks()
    configureSerialization()
    configureEventRouting()
    configurePersonRouting()
}
