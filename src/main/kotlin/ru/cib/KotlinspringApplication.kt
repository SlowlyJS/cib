package ru.cib

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableScheduling
@EnableRabbit
@SpringBootApplication
class KotlinspringApplication

fun main(args: Array<String>) {
	runApplication<KotlinspringApplication>(*args)
}
