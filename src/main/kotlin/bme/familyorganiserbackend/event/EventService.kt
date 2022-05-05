package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.family.FamilyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventService : AbstractService<Event>() {
    @Autowired
    private lateinit var eventRepository: EventRepository
    @Autowired
    private lateinit var familyService: FamilyService

    fun getAllByFamily(familyId: Long): List<Event> {
        val f=familyService.getById(familyId)!!
        return eventRepository.findByFamily(f)
    }
}