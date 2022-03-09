package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface PlainFamilyMemberMapper {
    fun entityToPlain(member:FamilyMember?): FamilyMemberPlain?
    companion object {
        val INSTANCE: PlainFamilyMemberMapper
            get() = Mappers.getMapper(PlainFamilyMemberMapper::class.java)
    }
}

class PlainFamilyMemberMapperImpl:PlainFamilyMemberMapper{


    override fun entityToPlain(member: FamilyMember?): FamilyMemberPlain? {
        if(member==null)
            return null
        val plain= FamilyMemberPlain(member.id,member.surname,member.lastName,member.email
            ,member.photo,member.birthDate,member.family?.id,member.uid,member.username)
        return plain
    }
}