package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.Mapper


@Mapper(componentModel = "spring", uses = [PlainFamilyMemberMapper::class])
abstract class GetFamilyMemberMapper : AbstractGetMapper<FamilyMember, FamilyMemberGet>() {


}

