package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.FamilyPlain
import bme.familyorganiserbackend.familymember.mapper.PlainFamilyMemberMapper
import org.mapstruct.factory.Mappers

interface PlainFamilyMapper {
    fun entityToPlain(family: Family?): FamilyPlain?
    companion object {
        val INSTANCE: PlainFamilyMapper
            get() = Mappers.getMapper(PlainFamilyMapper::class.java)
    }
}

class PlainFamilyMapperImpl:PlainFamilyMapper{

    override fun entityToPlain(family: Family?): FamilyPlain? {
        return if (family==null)
            null
        else {
            val plainFamilyMemberMapper = PlainFamilyMemberMapper.INSTANCE
            val headPlain=plainFamilyMemberMapper.entityToPlain(family.head)
            val membersPlain=family.members
                ?.map{ plainFamilyMemberMapper.entityToPlain(it) }
            val dto = FamilyPlain(
                family.id, family.name,
                headPlain, membersPlain, family.code
            )
            dto
        }
    }
}