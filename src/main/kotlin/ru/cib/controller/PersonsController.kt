package ru.cib.controller

import org.springframework.web.bind.annotation.*
import ru.cib.dto.PersonDto
import ru.cib.service.PersonService
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/main")
class PersonsController(
    private val personService: PersonService,
){

    private val LOGGER: Logger = LoggerFactory.getLogger(PersonsController::class.java)

    @ResponseBody
    @RequestMapping(path = ["/"])
    fun home(): String? {
        LOGGER.trace("This is TRACE")
        LOGGER.debug("This is DEBUG")
        LOGGER.info("This is INFO")
        LOGGER.warn("This is WARN")
        LOGGER.error("This is ERROR")
        return "Hi, show loggings in the console or file!"
    }

    @GetMapping()
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