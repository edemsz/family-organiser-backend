package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.FamilyPlain
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate

class FamilyMemberGet {
    var id: Long=0

    lateinit var surname: String

    lateinit var lastName: String

    lateinit var email: String

    var photo: String?=null

    var birthDate: LocalDate?=null

    var family: FamilyPlain?=null

    var username: String? = null

    @JsonIgnore
    var password:String?=null

    lateinit var uid:String
}