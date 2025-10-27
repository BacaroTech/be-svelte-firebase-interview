package mft.dev.mapper

import mft.dev.dto.event.EventDTO
import mft.dev.entity.EventEntity

fun EventEntity.toEventDTO(): EventDTO {
    return EventDTO(
        name,
        startDate,
        endDate,
        place
    )
}