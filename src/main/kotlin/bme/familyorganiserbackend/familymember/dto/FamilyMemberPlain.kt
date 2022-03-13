package bme.familyorganiserbackend.familymember.dto

import bme.familyorganiserbackend.abstracts.GetDTO
import bme.familyorganiserbackend.familymember.FamilyMember
import java.time.LocalDate

data class FamilyMemberPlain (
    var id: Long=0,
    var surname: String,
    var lastName: String,
    var email: String,
    var photo: String?=null,
    var birthDate: LocalDate?=null,
    var familyId:Long?=null,
    var uid:String,
    var username:String?=null
): GetDTO<FamilyMember>()


