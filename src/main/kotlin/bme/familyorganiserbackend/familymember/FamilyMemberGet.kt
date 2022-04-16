package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.family.FamilyPlain
import bme.familyorganiserbackend.familymember.FamilyMember
import java.time.LocalDate

data class FamilyMemberGet (
    val id:Long, val firstName:String, val lastName:String, val email:String, val photo:String?,
    val birthDate:LocalDate?, val family: FamilyPlain?, val username:String?, val uid:String
) : AbstractGetDTO<FamilyMember>