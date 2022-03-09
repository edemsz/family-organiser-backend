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

class CreateFamilyMemberMapperImpl:CreateFamilyMemberMapper{
    @Autowired
    private lateinit var familyRepository:FamilyRepository
    override fun CreateDTOToEntity(createDto:CreateFamilyMember): FamilyMember {
        val member=FamilyMember()
        member.lastName=createDto.lastName
        member.surname=createDto.surname
        member.birthDate=createDto.birthDate
        member.email=createDto.email
        member.photo=createDto.photo
        if(createDto.familyId!=null)
            member.family=familyRepository.getById(createDto.familyId!!)
        return member
    }


}