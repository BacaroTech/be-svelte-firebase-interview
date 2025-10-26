package mft.dev.entity

import mft.dev.table.PersonTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class PersonEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PersonEntity>(PersonTable)

    val uuid: UUID by PersonTable.uuid
    var firstName: String by PersonTable.firstName
    var lastName: String by PersonTable.lastName
    var email: String by PersonTable.email
    var telegramId: String? by PersonTable.telegramId
}