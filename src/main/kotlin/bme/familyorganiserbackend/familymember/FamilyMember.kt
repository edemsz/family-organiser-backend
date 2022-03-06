package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.Family
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="FAMILY_MEMBERS")
class FamilyMember() {
    constructor(
        surname:String, lastName:String,
        email:String, photo:String?, birthDate: LocalDate?, family:Family?) : this() {
        this.surname=surname
        this.lastName=lastName
        this.email=email
        this.photo=photo
        this.birthDate=birthDate
        this.family=family
        this.uId="1"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long=0

    @Column(nullable=false)
    lateinit var surname: String

    @Column(nullable=false)
    lateinit var lastName: String

    @Column(nullable=false)
    lateinit var email: String

    @Column(nullable=true)
    var photo: String?=null

    @Column(nullable=true)
    var birthDate: LocalDate?=null

    @ManyToOne(cascade= arrayOf(CascadeType.MERGE))
    @JsonManagedReference
    @JoinColumn(name="family_id", referencedColumnName = "id")
    var family: Family?=null

    @Column(nullable=true)
    var username: String? = null

    @JsonIgnore
    @Column(nullable=true)
    var password:String?=null

    @Column(nullable = false, name = "user_id")
    lateinit var uId:String


    companion object{
        fun fromFamilyMember(member: FamilyMember): FamilyMember {
            val newMember=FamilyMember()
            newMember.photo=member.photo
            newMember.email=member.email
            newMember.surname=member.surname
            newMember.lastName=member.lastName
            newMember.birthDate=member.birthDate
            return newMember
        }
    }
}