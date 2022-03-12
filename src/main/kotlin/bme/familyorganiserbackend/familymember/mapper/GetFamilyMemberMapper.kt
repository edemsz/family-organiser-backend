package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.family.mapper.PlainFamilyMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface GetFamilyMemberMapper {
    fun entityToGet(entity: FamilyMember): FamilyMemberGet
    companion object {
        val INSTANCE: GetFamilyMemberMapper
            get() = Mappers.getMapper(GetFamilyMemberMapper::class.java)
    }
}

