package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired


@Mapper
interface PlainFamilyMemberMapper {
    fun PlainToEntity(plain: FamilyMemberPlain):FamilyMember
    fun EntityToPlain(entity:FamilyMember): FamilyMemberPlain
    companion object {
        val INSTANCE: PlainFamilyMemberMapper
            get() = Mappers.getMapper(PlainFamilyMemberMapper::class.java)
    }
}

class PlainFamilyMemberMapperImpl:PlainFamilyMemberMapper{
    override fun PlainToEntity(plain: FamilyMemberPlain): FamilyMember {
        val member=FamilyMember()
        member.surname=plain.surname
        member.lastName=plain.lastName
        member.surname=plain.surname
        member.uid=plain.uid
        member.email=plain.email
        member.username=plain.username
        member.photo=plain.photo
        member.birthDate=plain.birthDate
        return member
    }

    override fun EntityToPlain(entity: FamilyMember): FamilyMemberPlain {
        val plain= FamilyMemberPlain(entity.id,entity.surname,entity.lastName,entity.email
            ,entity.photo,entity.birthDate,entity.family?.id,entity.uid,entity.username)
        return plain
    }
}