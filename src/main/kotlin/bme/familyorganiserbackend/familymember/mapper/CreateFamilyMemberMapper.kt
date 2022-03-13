package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper(componentModel = "spring")
abstract class CreateFamilyMemberMapper : AbstractCreateMapper<FamilyMember, CreateFamilyMember>() {
}

