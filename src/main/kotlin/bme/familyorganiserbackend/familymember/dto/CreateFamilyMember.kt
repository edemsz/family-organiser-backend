package bme.familyorganiserbackend.familymember.dto

import bme.familyorganiserbackend.abstracts.CreateDTO
import bme.familyorganiserbackend.familymember.FamilyMember
import java.time.LocalDate

data class CreateFamilyMember(
    var surname: String,
    var lastName: String,
    var email: String,
    var photo: String?=null,
    var birthDate: LocalDate?=null,
    var familyId:Long?=null,
) : CreateDTO<FamilyMember>()