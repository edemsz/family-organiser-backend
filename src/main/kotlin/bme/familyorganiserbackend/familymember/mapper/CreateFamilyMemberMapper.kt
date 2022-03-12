package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyRepository
import bme.familyorganiserbackend.familymember.PlainFamilyMemberMapper
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired


@Mapper
interface CreateFamilyMemberMapper {
    fun CreateDTOToEntity(createDto:CreateFamilyMember): FamilyMember
    companion object {
        val INSTANCE: CreateFamilyMemberMapper
            get() = Mappers.getMapper(CreateFamilyMemberMapper::class.java)
    }
}

