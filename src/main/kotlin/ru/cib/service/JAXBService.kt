package ru.cib.service

import org.springframework.stereotype.Service
import ru.cib.dto.PersonsDto
import java.io.File
import javax.xml.bind.JAXBContext

@Service
class JAXBService {
    fun unmarshaller (file: File): PersonsDto = JAXBContext.newInstance(PersonsDto::class.java).createUnmarshaller().unmarshal(file) as PersonsDto
}



