package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/event")
class EventController: AbstractController<Event, CreateEvent,GetEvent>() {
}