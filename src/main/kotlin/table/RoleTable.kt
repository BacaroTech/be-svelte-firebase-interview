package mft.dev.table

import mft.dev.enums.RoleType
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption
import java.util.UUID

object RoleTable : IntIdTable(name = "event_person_role") {
    val uuid: Column<UUID> = uuid(name = "uuid").autoGenerate().uniqueIndex()
    val role: Column<RoleType> = enumerationByName(name = "role", length = 128)
    val personId: Column<EntityID<Int>> = reference("person_id", PersonTable, onDelete = ReferenceOption.CASCADE)
    val eventId: Column<EntityID<Int>> = reference("event_id", EventTable, onDelete = ReferenceOption.CASCADE)
}