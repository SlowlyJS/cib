package ru.cib.controller

import org.springframework.web.bind.annotation.*
import ru.cib.dto.PersonDto
import ru.cib.service.PersonService

@RestController
@RequestMapping("/persons")

class PersonsController (
    private val personService: PersonService){

    @GetMapping

    fun getAll(): List<PersonDto> = personService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): PersonDto = personService.findById(id)

    @PostMapping
    fun  create (@RequestBody dto: PersonDto) = personService.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: PersonDto) {
        personService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete (@PathVariable id: Long) = personService.delete(id)

}