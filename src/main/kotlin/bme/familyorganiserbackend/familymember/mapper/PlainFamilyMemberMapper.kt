package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers


@Mapper(componentModel = "spring")
abstract class PlainFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberPlain>() {
    @Mapping(target = "familyId", source = "entity.family.id")
    abstract override fun entityToDto(entity: FamilyMember): FamilyMemberPlain

}

