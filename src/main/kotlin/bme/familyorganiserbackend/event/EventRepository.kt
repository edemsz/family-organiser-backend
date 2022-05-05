package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractRepository
import bme.familyorganiserbackend.family.Family

interface EventRepository :AbstractRepository<Event>{
    fun findByFamily(lastname: Family): List<Event>
}