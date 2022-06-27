package ru.cib.dto

import ru.cib.dto.HobbyDto
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
class PersonDto {


    @XmlElement(name = "name")
    var name: String? = null
    @XmlElement (name = "birthday")
    var birthday: String? = null
    @XmlElement (name = "Hobbies")
    var hobbies: List<HobbyDto>? = mutableListOf()

    override fun toString(): String {
        return "Name: $name, Birthday: $birthday, Hobbies: $hobbies"
    }
}
