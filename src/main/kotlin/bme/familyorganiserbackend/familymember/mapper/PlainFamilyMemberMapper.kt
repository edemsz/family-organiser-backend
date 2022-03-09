package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface PlainFamilyMemberMapper {
    fun PlainToEntity(plain: FamilyMemberPlain):FamilyMember
    fun EntityToPlain(member:FamilyMember?): FamilyMemberPlain?
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

    override fun EntityToPlain(member: FamilyMember?): FamilyMemberPlain? {
        if(member==null)
            return null
        val plain= FamilyMemberPlain(member.id,member.surname,member.lastName,member.email
            ,member.photo,member.birthDate,member.family?.id,member.uid,member.username)
        return plain
    }
}