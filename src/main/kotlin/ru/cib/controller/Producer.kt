package ru.cib.controller

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.cib.entity.PersonEntity
import ru.cib.repository.PersonRepository

@Component
class Producer (private val rabbitTemplate: RabbitTemplate,
                private val personRepository: PersonRepository) {

    @Scheduled(fixedDelay = 1000)
    fun sendMessage() {
        val personEntity = PersonEntity()
        personRepository.findByOrderByName().forEach {
            rabbitTemplate.convertAndSend("routingkey", personEntity)
        }

    }
}
