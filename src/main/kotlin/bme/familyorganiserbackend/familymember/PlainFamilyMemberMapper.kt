package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget


@Mapper(componentModel = "spring")
abstract class PlainFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberPlain>() {
    @AfterMapping
    fun getId(@MappingTarget target:FamilyMemberPlain,source:FamilyMember){
        target.familyId=source.family?.id
    }
}

