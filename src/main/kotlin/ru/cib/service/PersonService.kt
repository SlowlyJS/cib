package ru.cib.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.cib.dto.PersonDto
import ru.cib.repository.PersonRepository
import java.io.File

@Service
class PersonService
    (private val personRepository: PersonRepository,
     private val entityService: EntityService
) {


    fun saveFromXmlToDb(file: File): Boolean {
        return try {
            personRepository.saveAll(entityService.fromDtoToEntity(file))
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun getAll(): List<PersonDto> {
        return personRepository.findByOrderByName().map {
            it.toDto()
        }
    }

    fun findById(id: Long): PersonDto {
        return personRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw RuntimeException("person not found")
    }

    fun delete(id: Long) {
        val existingPerson = personRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Person not found")
        personRepository.deleteById(existingPerson.id!!)
    }

    fun create(dto: PersonDto): Long? {
        return personRepository.save(dto.toEntity()).id
    }

    fun update(id: Long, dto: PersonDto) {
        val existingPerson = personRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Person not found")
        existingPerson.name = dto.name
        existingPerson.birthday = dto.birthday
        personRepository.save(existingPerson)
    }


}