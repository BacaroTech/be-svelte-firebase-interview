package mft.dev.routing

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.request.*
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import mft.dev.dto.person.InsertPersonDTO
import mft.dev.dto.person.PersonDTO
import mft.dev.response.respondError
import mft.dev.response.respondSuccess
import mft.dev.service.impl.PersonService
import org.koin.ktor.ext.inject
import java.util.UUID

fun Application.configurePersonRouting() {
    val personService: PersonService by inject()

    routing {
        route("/people") {
            post("/register") {
                val dto: InsertPersonDTO = call.receive<InsertPersonDTO>()

                val uuid: UUID = personService.insert(dto)

                return@post call.respondSuccess("Person inserted correctly", uuid.toString())
            }

            get("/{uuid}") {
                val uuid = try {
                    UUID.fromString(call.request.headers["uuid"])
                } catch (e: IllegalArgumentException) {
                    throw BadRequestException("Invalid uuid")
                }

                val response: PersonDTO? = personService.get(uuid)

                return@get response?.let {
                    call.respondSuccess("Person found correctly", it)
                } ?: call.respondError(HttpStatusCode.Forbidden, "Access denied")
            }
        }
    }
}