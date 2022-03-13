package bme.familyorganiserbackend.family.dto

import bme.familyorganiserbackend.abstracts.CreateDTO
import bme.familyorganiserbackend.family.Family

data class CreateFamily (
    var name: String,
    var headId: Long? = null,
    var memberIds: List<Long?>? = null,
):CreateDTO<Family>()