package mft.dev.dto.person

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InsertPersonDTO(
    @SerialName("first_name")
    @Required
    val firstName: String,
    @SerialName("last_name")
    @Required
    val lastName: String,
    @SerialName("email")
    @Required
    val email: String,
    @SerialName("telegram_id")
    val telegramId: String?
)