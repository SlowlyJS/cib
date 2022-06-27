package ru.cib.configuration

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfiguration {

    var queueName: String = "queue12"

    var exchange: String = "exchanges"

    private val routingkey: String = "routingkey"

    @Bean
    fun queue(): Queue? {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): DirectExchange? {
        return DirectExchange(exchange)
    }

    @Bean
    fun binding(queue: Queue?, exchange: DirectExchange?): Binding? {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey)
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }


    @Bean
    fun template(connectionFactory: ConnectionFactory): AmqpTemplate? {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jsonMessageConverter()
        return rabbitTemplate
    }
}