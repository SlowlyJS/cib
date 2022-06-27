package ru.cib.dto

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Hobbies")
class HobbyDto {
    @XmlElement(name = "hobby")
    var hobby: String? = null

    override fun toString(): String {
        return "Hobby: $hobby"
    }
}