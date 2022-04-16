package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberPlain
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget


@Mapper(componentModel = "spring")
abstract class UserMapper :AbstractGetMapper<FamilyMember,User>() {
    @AfterMapping
    fun asd(@MappingTarget target: FamilyMemberPlain, source:FamilyMember){
        println("asd")
    }
}