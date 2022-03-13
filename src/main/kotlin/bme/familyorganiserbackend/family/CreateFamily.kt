package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.CreateDTO

data class CreateFamily (
    var name: String,
    var headId: Long? = null,
    var memberIds: List<Long?>? = null,
):CreateDTO<Family>()