package bme.familyorganiserbackend.mappers

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.entities.FamilyMember
import bme.familyorganiserbackend.dtos.FamilyMemberGet
import org.mapstruct.Mapper


@Mapper(componentModel = "spring", uses = [PlainFamilyMemberMapper::class])
abstract class GetFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberGet>() {


}

