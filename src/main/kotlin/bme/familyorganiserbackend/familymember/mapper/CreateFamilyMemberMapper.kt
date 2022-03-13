package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.abstracts.AbstractMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper(componentModel = "spring")
abstract class CreateFamilyMemberMapper : AbstractMapper<FamilyMember, CreateFamilyMember>() {

    companion object {
        val INSTANCE: CreateFamilyMemberMapper
            get() = Mappers.getMapper(CreateFamilyMemberMapper::class.java)
    }
}

