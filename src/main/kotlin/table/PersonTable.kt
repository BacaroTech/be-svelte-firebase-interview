package mft.dev.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.util.UUID

object PersonTable : IntIdTable(name = "people") {
    val uuid: Column<UUID> = uuid(name = "uuid").autoGenerate().uniqueIndex()
    val firstName: Column<String> = varchar(name = "first_name", length = 128)
    val lastName: Column<String> = varchar(name = "last_name", length = 128)
    val email: Column<String> = varchar(name = "email", length = 128).uniqueIndex()
    val telegramId: Column<String?> = varchar(name = "telegram_id", length = 128).uniqueIndex().nullable()
}