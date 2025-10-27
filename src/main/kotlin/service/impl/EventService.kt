package mft.dev.service.impl

import kotlinx.coroutines.Dispatchers
import mft.dev.dto.event.EventDTO
import mft.dev.dto.event.InsertEventDTO
import mft.dev.entity.EventEntity
import mft.dev.entity.PersonEntity
import mft.dev.mapper.toEventDTO
import mft.dev.mapper.toPersonDTO
import mft.dev.service.IEventService
import mft.dev.table.EventTable
import mft.dev.table.PersonTable
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.util.UUID

class EventService : IEventService {
    override suspend fun insert(dto: InsertEventDTO): UUID =
        dbQuery {
            EventEntity.new {
                name = dto.name
                startDate = dto.startDate
                endDate = dto.endDate
                place = dto.place
            }.uuid
        }

    override suspend fun get(uuid: UUID): EventDTO? =
        dbQuery {
            EventEntity.find {
                EventTable.uuid eq uuid
            }.singleOrNull()?.toEventDTO()
        }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}