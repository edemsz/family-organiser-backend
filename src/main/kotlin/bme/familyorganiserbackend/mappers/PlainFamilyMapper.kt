package bme.familyorganiserbackend.mappers

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.dtos.FamilyPlain
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [PlainFamilyMemberMapper::class])
abstract class PlainFamilyMapper : AbstractGetMapper<Family, FamilyPlain>() {


}

