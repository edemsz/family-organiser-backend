package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.family.CreateFamily
import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateFamilyMapper : AbstractCreateMapper<Family, CreateFamily>()