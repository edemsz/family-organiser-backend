package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface PlainFamilyMemberMapper {
    fun entityToPlain(member: FamilyMember?): FamilyMemberPlain?
    companion object {
        val INSTANCE: PlainFamilyMemberMapper
            get() = Mappers.getMapper(PlainFamilyMemberMapper::class.java)
    }
}

