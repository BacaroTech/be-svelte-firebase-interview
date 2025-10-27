package mft.dev.configuration

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import mft.dev.serializer.LocalDateTimeSerializer
import java.time.LocalDateTime

fun Application.configureSerialization() {
    val customSerializers = SerializersModule {
        contextual(LocalDateTime::class, LocalDateTimeSerializer)
    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            explicitNulls = false
            serializersModule = customSerializers
        })
    }
}
