package bme.familyorganiserbackend.mappers

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.dtos.CreateFamily
import bme.familyorganiserbackend.entities.Family
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateFamilyMapper : AbstractCreateMapper<Family, CreateFamily>()