package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.entities.FamilyMember
import java.time.LocalDate

data class CreateFamilyMember(
    var surname: String,
    var lastName: String,
    var email: String,
    var photo: String?=null,
    var birthDate: LocalDate?=null,
    var familyId:Long?=null,
) : AbstractCreateDTO<FamilyMember>()