package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.entities.Family

data class FamilyPlain (
    var id: Long = 0,
    var name:String,
    var head: FamilyMemberPlain?=null,
    var members:List<FamilyMemberPlain?>?=null,
    var code:String
):AbstractGetDTO<Family>()