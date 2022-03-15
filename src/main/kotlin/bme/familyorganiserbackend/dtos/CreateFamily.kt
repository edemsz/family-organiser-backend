package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.entities.Family

data class CreateFamily (
    var name: String,
    var headId: Long? = null,
    var memberIds: List<Long?>? = null,
    var code:String
):AbstractCreateDTO<Family>()