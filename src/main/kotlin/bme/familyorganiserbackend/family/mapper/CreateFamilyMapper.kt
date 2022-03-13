package bme.familyorganiserbackend.family.mapper

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.family.dto.CreateFamily
import bme.familyorganiserbackend.family.Family
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateFamilyMapper : AbstractCreateMapper<Family, CreateFamily>()