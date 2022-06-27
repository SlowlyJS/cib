package ru.cib.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, scope = PersonEntity::class, property="@id")
@Entity
@Table(name = "persons")
class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var birthday: String? = null

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var hobbies: List<HobbyEntity>? = mutableListOf()

    override fun toString(): String {
    return "Id: $id, Name: $name, Birthday: $birthday, Hobbies: $hobbies"
    }
}