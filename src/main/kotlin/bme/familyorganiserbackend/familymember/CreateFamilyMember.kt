package bme.familyorganiserbackend.familymember

import java.time.LocalDate

class CreateFamilyMember {
    lateinit var surname: String

    lateinit var lastName: String

    lateinit var email: String

    var photo: String?=null

    var birthDate: LocalDate?=null

    var familyId:Long?=null

    lateinit var uid:String

}