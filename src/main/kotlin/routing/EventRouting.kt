package mft.dev.routing

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.request.receive
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import mft.dev.dto.event.EventDTO
import mft.dev.dto.event.InsertEventDTO
import mft.dev.dto.person.PersonDTO
import mft.dev.response.respondError
import mft.dev.response.respondSuccess
import mft.dev.service.impl.EventService
import org.koin.ktor.ext.inject
import java.util.UUID

fun Application.configureEventRouting() {
    val eventService: EventService by inject()

    routing {
        route("/events") {
            post {
                val dto: InsertEventDTO = call.receive<InsertEventDTO>()

                val uuid: UUID = eventService.insert(dto)

                return@post call.respondSuccess("Event inserted correctly", uuid.toString())
            }
            get("/{uuid}") {
                val uuid = try {
                    UUID.fromString(call.request.headers["uuid"])
                } catch (e: IllegalArgumentException) {
                    throw BadRequestException("Invalid uuid")
                }

                val response: EventDTO? = eventService.get(uuid)

                return@get response?.let {
                    call.respondSuccess("Event found correctly", it)
                } ?: call.respondError(HttpStatusCode.Forbidden, "Access denied")
            }
        }
    }
}