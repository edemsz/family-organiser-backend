package bme.familyorganiserbackend.mappers

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.services.FamilyService
import bme.familyorganiserbackend.entities.FamilyMember
import bme.familyorganiserbackend.dtos.CreateFamilyMember
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.springframework.beans.factory.annotation.Autowired


@Mapper(componentModel = "spring")
abstract class CreateFamilyMemberMapper : AbstractCreateMapper<FamilyMember, CreateFamilyMember>() {

    @Autowired
    private lateinit var familyService: FamilyService
    @AfterMapping
    fun fillReferences(dto: CreateFamilyMember, @MappingTarget member: FamilyMember){
        member.family= dto.familyId?.let { familyService.getById(it) }
    }
}

