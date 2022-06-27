package ru.cib.c0ontroller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.MessageChannels
import org.springframework.integration.dsl.integrationFlow
import org.springframework.integration.file.dsl.Files
import ru.cib.service.PersonService
import java.io.File

@Configuration
class ChannelsConfiguration {

    @Bean
    fun xml() = MessageChannels.direct().get()
    @Bean
    fun errors() = MessageChannels.direct().get()
}


@Configuration
class FileConfiguration(
    private val channels: ChannelsConfiguration,
    private val personService: PersonService
) {

    private val input = File("C:\\Users\\vvede\\OneDrive\\Рабочий стол\\in")
    private val output = File("C:\\Users\\vvede\\OneDrive\\Рабочий стол\\out")
    private val err = File("C:\\Users\\vvede\\OneDrive\\Рабочий стол\\error")

    @Bean
    fun filesFlow() = integrationFlow(
        Files.inboundAdapter(this.input).autoCreateDirectory(true),
        { poller { it.fixedDelay(500).maxMessagesPerPoll(1) } }
    ) {

        filter<File> { it.isFile }
        route<File> {
            when (personService.saveFromXmlToDb(it)) {
                true -> channels.xml()
                false -> channels.errors()
            }
        }
    }

    @Bean
    fun fileToDb() = integrationFlow(channels.xml()) {
        handle(Files.outboundAdapter(output).deleteSourceFiles(true).autoCreateDirectory(true))
    }

    @Bean
    fun errFlow() = integrationFlow(channels.errors()) {
        handle(Files.outboundAdapter(err).autoCreateDirectory(true).deleteSourceFiles(true))
    }
}
