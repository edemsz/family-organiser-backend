package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.FamilyPlain
import java.time.LocalDate

data class FamilyMemberGet (
    val id:Long, val surname:String, val lastName:String, val email:String, val photo:String?,
    val birthDate:LocalDate?, val family:FamilyPlain?, val username:String?, val uid:String)