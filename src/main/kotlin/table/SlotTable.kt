package mft.dev.table

import mft.dev.enums.SlotStatus
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object SlotTable : UUIDTable(name = "slots") {
    val interviewDate: Column<LocalDateTime> = datetime(name = "interview_date")
    val place: Column<String> = varchar(name = "place", length = 128)
    val topic: Column<String?> = varchar(name = "topic", length = 128).nullable()
    val status: Column<SlotStatus> = enumerationByName(name = "status", length = 128)
    val roleId: Column<EntityID<Int>> = reference("role_id", RoleTable, onDelete = ReferenceOption.SET_NULL)
}