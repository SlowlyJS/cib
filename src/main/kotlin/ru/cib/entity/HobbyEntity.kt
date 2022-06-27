package ru.cib.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, scope = HobbyEntity::class, property="@id")
@Table (name = "hobbies")
@Entity
class HobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null

    @Column (name = "hobby")
    var hobby: String? = ""


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    var person: PersonEntity? = null

    override fun toString(): String {
        return "Id: $id, Hobby: $hobby"
    }
}