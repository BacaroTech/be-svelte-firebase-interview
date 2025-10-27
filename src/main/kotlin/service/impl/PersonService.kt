package mft.dev.service.impl

import kotlinx.coroutines.Dispatchers
import mft.dev.dto.person.InsertPersonDTO
import mft.dev.dto.person.PersonDTO
import mft.dev.entity.PersonEntity
import mft.dev.mapper.toPersonDTO
import mft.dev.service.IPersonService
import mft.dev.table.PersonTable
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.util.UUID

class PersonService : IPersonService {
    override suspend fun insert(dto: InsertPersonDTO): UUID =
        dbQuery {
            PersonEntity.new {
                firstName = dto.firstName
                lastName = dto.lastName
                email = dto.email
                telegramId = dto.telegramId
            }.uuid
        }

    override suspend fun get(uuid: UUID): PersonDTO? =
        dbQuery {
            PersonEntity.find {
                PersonTable.uuid eq uuid
            }.singleOrNull()?.toPersonDTO()
        }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}