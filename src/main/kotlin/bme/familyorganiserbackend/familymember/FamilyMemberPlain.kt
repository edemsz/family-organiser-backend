package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.Family
import java.time.LocalDate


class FamilyMemberPlain() {
    constructor(
        id:Long,surname:String, lastName:String,
        email:String, photo:String?, birthDate: LocalDate?, family: Family?) : this() {
        this.surname=surname
        this.id=id
        this.lastName=lastName
        this.email=email
        this.photo=photo
        this.birthDate=birthDate
        this.familyId=family?.id
    }
    constructor(member: FamilyMember):
    this(member.id,member.surname,member.lastName,member.email,member.photo,member.birthDate,member.family)

    var id: Long=0

    lateinit var surname: String

    lateinit var lastName: String

    lateinit var email: String

    var photo: String?=null

    var birthDate: LocalDate?=null

    var familyId:Long?=null

    public fun toFamilyMember():FamilyMember{
        val family=null//FamilyRepository.getById(familyId)
        return FamilyMember(id,surname,lastName,email,photo,birthDate,null)
    }

}