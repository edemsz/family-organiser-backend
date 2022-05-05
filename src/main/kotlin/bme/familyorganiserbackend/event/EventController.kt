package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractController
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/event")
class EventController: AbstractController<Event, CreateEvent,GetEvent>() {
    @Autowired
    private lateinit var eventService: EventService

    @GetMapping("/by-family/{family-id}")
    @ApiOperation("Searching the events owned by a specified family")
    fun searchByFamily(@PathVariable(value = "family-id") familyId:Long): ResponseEntity<List<GetEvent>> {
        val events=eventService.getAllByFamily(familyId)
        return ResponseEntity.ok(getMapper.listOfEntitiesToDtos(events))
    }

}