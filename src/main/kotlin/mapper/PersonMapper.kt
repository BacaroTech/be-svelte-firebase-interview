package mft.dev.mapper

import mft.dev.dto.person.PersonDTO
import mft.dev.entity.PersonEntity

fun PersonEntity.toPersonDTO(): PersonDTO {
    return PersonDTO(
        firstName,
        lastName,
        telegramId
    )
}