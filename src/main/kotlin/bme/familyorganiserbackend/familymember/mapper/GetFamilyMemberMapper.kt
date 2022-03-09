package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.family.mapper.PlainFamilyMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.PlainFamilyMemberMapper
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface GetFamilyMemberMapper {
    fun EntityToGet(entity: FamilyMember): FamilyMemberGet
    companion object {
        val INSTANCE: GetFamilyMemberMapper
            get() = Mappers.getMapper(GetFamilyMemberMapper::class.java)
    }
}

class GetFamilyMemberMapperImpl:GetFamilyMemberMapper{

    override fun EntityToGet(entity: FamilyMember): FamilyMemberGet {
        val plainFamilyMapper: PlainFamilyMapper =PlainFamilyMapper.INSTANCE
        val get= FamilyMemberGet(entity.id,entity.surname,entity.lastName,entity.email
            ,entity.photo,entity.birthDate,plainFamilyMapper.EntityToPlain(entity.family),entity.username,entity.uid)
        return get
    }
}