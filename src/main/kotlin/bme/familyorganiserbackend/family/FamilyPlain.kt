package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain

data class FamilyPlain (
    var id: Long = 0,

    var name:String,

    var head: FamilyMemberPlain?=null,

    var members:List<FamilyMemberPlain?>?=null,

    var code:String

)