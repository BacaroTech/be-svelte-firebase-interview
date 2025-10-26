package mft.dev.entity

import mft.dev.enums.RoleType
import mft.dev.table.RoleTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class RoleEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<RoleEntity>(RoleTable)

    val uuid: UUID by RoleTable.uuid
    var role: RoleType by RoleTable.role
    var personEntity: PersonEntity by PersonEntity referencedOn RoleTable.personId
    var eventEntity: EventEntity by EventEntity referencedOn RoleTable.eventId
}