package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.FamilyPlain
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import bme.familyorganiserbackend.familymember.mapper.GetFamilyMemberMapper
import org.mapstruct.factory.Mappers

interface PlainFamilyMapper {
    fun EntityToPlain(entity: Family?): FamilyPlain?
    companion object {
        val INSTANCE: PlainFamilyMapper
            get() = Mappers.getMapper(PlainFamilyMapper::class.java)
    }
}

class PlainFamilyMapperImpl:PlainFamilyMapper{

    override fun EntityToPlain(entity: Family?): FamilyPlain? {
        if (entity==null)
            return null
        else {
            val entity2 = entity!!
            val dto = FamilyPlain(entity2.id, entity2.name,
                null, null, entity2.code)
            return dto
        }
    }
}