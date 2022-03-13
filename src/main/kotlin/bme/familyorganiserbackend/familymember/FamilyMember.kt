package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.family.Family
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "FAMILY_MEMBERS")
class FamilyMember():AbstractEntity() {


    constructor(
        surname: String, lastName: String,
        email: String, photo: String?, birthDate: LocalDate?, family: Family?
    ) : this() {
        this.surname = surname
        this.lastName = lastName
        this.email = email
        this.photo = photo
        this.birthDate = birthDate
        this.family = family
        this.setUid()
    }

    fun setUid(): FamilyMember {
        val STRING_LENGTH = 10
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val randomString = (1..STRING_LENGTH)
            .map { kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
        this.uid = randomString
        return this
    }


    @Column(nullable = false)
    lateinit var surname: String

    @Column(nullable = false)
    lateinit var lastName: String

    @Column(nullable = false)
    lateinit var email: String

    @Column(nullable = true)
    var photo: String? = null

    @Column(nullable = true)
    var birthDate: LocalDate? = null

    @ManyToOne(cascade= [CascadeType.MERGE])
    @JsonManagedReference
    @JoinColumn(name="family_id", referencedColumnName = "id")
    var family: Family?=null

    @Column(nullable = true)
    var username: String? = null

    @JsonIgnore
    @Column(nullable = true)
    var password: String? = null

    @Column(nullable = false, name = "user_id")
    lateinit var uid: String

    @PreRemove
    private fun removeHeadFromFamily() {
        if (this.family?.head == this) {
            this.family?.head = null
        }
    }

}