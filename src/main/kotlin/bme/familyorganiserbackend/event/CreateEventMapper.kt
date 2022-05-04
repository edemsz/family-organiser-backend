package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.family.FamilyService
import org.mapstruct.AfterMapping
import org.mapstruct.MappingTarget
import org.springframework.beans.factory.annotation.Autowired

abstract class CreateEventMapper :AbstractCreateMapper<Event,CreateEvent>(){
    @Autowired
    private lateinit var familyService: FamilyService
    @AfterMapping
    fun fillReferences(dto: CreateEvent, @MappingTarget event: Event){
        event.family=  familyService.getById(dto.familyId)
    }
}