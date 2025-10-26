package mft.dev.entity

import mft.dev.table.EventTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime
import java.util.UUID

class EventEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<EventEntity>(EventTable)

    val uuid: UUID by EventTable.uuid
    var name: String by EventTable.name
    var startDate: LocalDateTime by EventTable.startDate
    var endDate: LocalDateTime by EventTable.endDate
    var place: String by EventTable.place
}
