package ru.cib.service

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import ru.cib.entity.PersonEntity
import ru.cib.repository.PersonRepository

@Component
class Listener (private val personRepository: PersonRepository) {

    @RabbitListener(queues = ["queue12"])
    fun listener(personEntity: PersonEntity): String {
        personRepository.save(personEntity)
        return "Save"
    }
}