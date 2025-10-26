package mft.dev.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import java.util.UUID

object EventTable : IntIdTable(name = "events"){
    val uuid: Column<UUID> = uuid(name = "uuid").autoGenerate().uniqueIndex()
    val name: Column<String> = varchar(name = "name", length = 256)
    val startDate: Column<LocalDateTime> = datetime(name = "start_date")
    val endDate: Column<LocalDateTime> = datetime(name = "end_date")
    val place: Column<String> = varchar(name = "place", length = 256)
}