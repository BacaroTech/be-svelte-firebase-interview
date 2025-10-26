package mft.dev.enums

import kotlinx.serialization.Serializable

@Serializable
enum class RoleType {
    ADMIN,
    ORGANIZER,
    SPEAKER
}