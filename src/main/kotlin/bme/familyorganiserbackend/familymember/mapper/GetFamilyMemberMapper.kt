package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.family.mapper.PlainFamilyMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers


@Mapper
interface GetFamilyMemberMapper {
    fun entityToGet(entity: FamilyMember): FamilyMemberGet
    fun listOfMembersToGet(list:List<FamilyMember>):List<FamilyMemberGet>
    @Mapping(target = "familyId", source = "member.family.id")
    fun memberToPlain(member: FamilyMember?): FamilyMemberPlain?

    companion object {
        val INSTANCE: GetFamilyMemberMapper
            get() = Mappers.getMapper(GetFamilyMemberMapper::class.java)
    }
}

