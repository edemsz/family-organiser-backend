package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import java.time.LocalDateTime

data class GetEvent(
    val id:Long, val start:LocalDateTime, val end:LocalDateTime, var familyId:Long,
    val place:String

) :AbstractGetDTO<Event>