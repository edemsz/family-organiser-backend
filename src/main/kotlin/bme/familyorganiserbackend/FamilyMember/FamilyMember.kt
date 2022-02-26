package bme.familyorganiserbackend.FamilyMember

import java.util.Date
import javax.persistence.*

@Entity
@Table(name="FAMILY_MEMBERS")
class FamilyMember {
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
    var birthDate: Date?=null

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