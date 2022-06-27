package ru.cib.service

import ru.cib.dto.HobbyDto
import ru.cib.dto.PersonDto
import ru.cib.entity.HobbyEntity
import ru.cib.entity.PersonEntity

fun PersonDto.toEntity() = PersonEntity().let { it ->
    it.name = this.name
    it.birthday = this.birthday
    it.hobbies = this.hobbies?.map { it.hobbyToEntity() }
    it
    }

fun PersonEntity.toDto() = PersonDto().let { it ->
    it.name = this.name
    it.birthday = this.birthday
    it.hobbies = this.hobbies?.map { it.hobbyToDto() }
    it
}

fun HobbyDto.hobbyToEntity() = HobbyEntity().let {
    it.hobby = this.hobby
    it
}

fun HobbyEntity.hobbyToDto() = HobbyDto().let {
    it.hobby = this.hobby

    it

}