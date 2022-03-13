package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.dto.FamilyPlain
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
abstract class PlainFamilyMapper : AbstractGetMapper<Family, FamilyPlain>() {

    @Mapping(target = "familyId", source = "member.family.id")
    abstract fun memberToPlain(member: FamilyMember?): FamilyMemberPlain?

}

