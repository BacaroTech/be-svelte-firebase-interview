package mft.dev.enums

import kotlinx.serialization.Serializable

@Serializable
enum class SlotStatus {
    UNSIGNED,
    SIGNED
}