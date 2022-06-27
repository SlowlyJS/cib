package ru.cib.dto

import ru.cib.dto.PersonDto
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Persons")
@XmlAccessorType(XmlAccessType.FIELD)
class PersonsDto {
    @XmlElement(name = "Person")
    var persons: List<PersonDto>? = null
}