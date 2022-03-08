package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.FamilyMemberPlain

class FamilyPlain {
    var id: Long = 0

    lateinit var name:String

    var head: FamilyMemberPlain?=null

    var members:List<FamilyMemberPlain?>?=null

    lateinit var code:String

}