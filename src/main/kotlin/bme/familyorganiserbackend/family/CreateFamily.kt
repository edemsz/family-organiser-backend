package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.family.Family

data class CreateFamily (
    var name: String,
    var headId: Long? = null,
    var memberIds: List<Long?>? = null,
    var code:String
):AbstractCreateDTO<Family>()