package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
abstract class GetEventMapper : AbstractGetMapper<Event,GetEvent>(){

    @AfterMapping
    fun getId(@MappingTarget target: GetEvent, source: Event){
        target.familyId= source.family?.id!!
    }
}