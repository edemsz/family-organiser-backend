package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.FamilyPlain
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import bme.familyorganiserbackend.familymember.mapper.PlainFamilyMemberMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface PlainFamilyMapper {
    fun entityToPlain(family: Family?): FamilyPlain?
    @Mapping(target = "familyId", source = "member.family.id")
    fun memberToPlain(member: FamilyMember?): FamilyMemberPlain?

    companion object {
        val INSTANCE: PlainFamilyMapper
            get() = Mappers.getMapper(PlainFamilyMapper::class.java)
    }
}

