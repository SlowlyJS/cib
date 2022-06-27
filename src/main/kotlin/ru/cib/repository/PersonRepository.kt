package ru.cib.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.cib.entity.PersonEntity

interface PersonRepository: JpaRepository<PersonEntity, Long>{
    fun findByOrderByName(): List<PersonEntity>
}