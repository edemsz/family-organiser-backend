package bme.familyorganiserbackend.familymember

import java.time.LocalDate

class FamilyMemberPlain {
    var id: Long=0

    lateinit var surname: String

    lateinit var lastName: String

    lateinit var email: String

    var photo: String?=null

    var birthDate: LocalDate?=null

    var familyId:Long?=null

    lateinit var uid:String


}