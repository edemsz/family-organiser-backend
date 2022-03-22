package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
abstract class PlainFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberPlain>() {
    @Mapping(target = "familyId", source = "entity.family.id")
    abstract override fun entityToDto(entity: FamilyMember): FamilyMemberPlain

}

