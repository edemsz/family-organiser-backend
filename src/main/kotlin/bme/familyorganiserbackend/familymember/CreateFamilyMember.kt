package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.familymember.FamilyMember
import java.time.LocalDate

data class CreateFamilyMember(
    var firstName: String,
    var lastName: String,
    var email: String,
    var photo: String?=null,
    var birthDate: LocalDate?=null,
    var familyId:Long?=null,
) : AbstractCreateDTO<FamilyMember>