package mft.dev.entity

import mft.dev.enums.SlotStatus
import mft.dev.table.SlotTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime
import java.util.UUID

class SlotEntity(uuid: EntityID<UUID>) : UUIDEntity(uuid) {
    companion object : UUIDEntityClass<SlotEntity>(SlotTable)

    var interviewDate: LocalDateTime by SlotTable.interviewDate
    var place: String by SlotTable.place
    var topic: String? by SlotTable.topic
    var status: SlotStatus by SlotTable.status
    var roleEntity: RoleEntity by RoleEntity referencedOn SlotTable.roleId
}