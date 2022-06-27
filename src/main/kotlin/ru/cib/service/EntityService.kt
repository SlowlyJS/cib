package ru.cib.service

import org.springframework.stereotype.Service
import ru.cib.entity.PersonEntity
import java.io.File

@Service
class EntityService (private val jaxbService: JAXBService)
{
    fun fromDtoToEntity(file: File): List<PersonEntity> {
        val list = mutableListOf<PersonEntity>()
        jaxbService.unmarshaller(file).persons?.forEach { personDto ->
            list.add(personDto.toEntity())
            list.forEach { hobby ->
                hobby.hobbies?.forEach {
                    it.person = hobby
                }
            }
        }
        return list
    }
}