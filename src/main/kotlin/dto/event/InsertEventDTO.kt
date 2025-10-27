package mft.dev.dto.event

import kotlinx.serialization.Contextual
import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class InsertEventDTO(
    @SerialName("name")
    @Required
    val name: String,
    @SerialName("start_date")
    @Required
    @Contextual
    val startDate: LocalDateTime,
    @SerialName("end_date")
    @Required
    @Contextual
    val endDate: LocalDateTime,
    @SerialName("place")
    @Required
    val place: String
)
