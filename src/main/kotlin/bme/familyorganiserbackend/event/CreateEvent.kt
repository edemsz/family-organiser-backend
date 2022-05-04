package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import java.time.LocalDateTime

data class CreateEvent(
    val start: LocalDateTime, val end: LocalDateTime, val familyId:Long
) : AbstractCreateDTO<Event>