package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.abstracts.AbstractMapper
import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.FamilyPlain
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
abstract class PlainFamilyMapper : AbstractMapper<Family, FamilyPlain>() {

    @Mapping(target = "familyId", source = "member.family.id")
    abstract fun memberToPlain(member: FamilyMember?): FamilyMemberPlain?

    companion object {
        val INSTANCE: PlainFamilyMapper
            get() = Mappers.getMapper(PlainFamilyMapper::class.java)
    }
}

