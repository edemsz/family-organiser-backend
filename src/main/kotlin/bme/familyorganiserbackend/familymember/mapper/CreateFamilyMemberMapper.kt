package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface CreateFamilyMemberMapper {
    fun CreateDTOToEntity(createDto:CreateFamilyMember): FamilyMember
    companion object {
        val INSTANCE: CreateFamilyMemberMapper
            get() = Mappers.getMapper(CreateFamilyMemberMapper::class.java)
    }
}

