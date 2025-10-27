package mft.dev.service

import mft.dev.dto.event.EventDTO
import mft.dev.dto.event.InsertEventDTO
import java.util.UUID

interface IEventService {
    suspend fun insert(dto: InsertEventDTO): UUID

    suspend fun get(uuid: UUID): EventDTO?
}