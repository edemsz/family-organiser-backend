package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers


@Mapper(componentModel = "spring")
abstract class GetFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberGet>() {

    @Mapping(target = "familyId", source = "member.family.id")
    abstract fun memberToPlain(member: FamilyMember?): FamilyMemberPlain?

    companion object {
        val INSTANCE: GetFamilyMemberMapper
            get() = Mappers.getMapper(GetFamilyMemberMapper::class.java)
    }
}

