package bme.familyorganiserbackend.familymember.mapper

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers


@Mapper(componentModel = "spring", uses = [PlainFamilyMemberMapper::class])
abstract class GetFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberGet>() {


}

