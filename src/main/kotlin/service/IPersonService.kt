package mft.dev.service

import mft.dev.dto.person.InsertPersonDTO
import mft.dev.dto.person.PersonDTO
import java.util.UUID

interface IPersonService {
    suspend fun insert(dto: InsertPersonDTO): UUID

    suspend fun get(uuid: UUID): PersonDTO?
}