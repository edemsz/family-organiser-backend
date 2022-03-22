package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.familymember.PlainFamilyMemberMapper
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [PlainFamilyMemberMapper::class])
abstract class PlainFamilyMapper : AbstractGetMapper<Family, FamilyPlain>() {


}

