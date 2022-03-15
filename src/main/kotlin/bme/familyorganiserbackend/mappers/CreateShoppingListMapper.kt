package bme.familyorganiserbackend.mappers

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.dtos.CreateShoppingList
import bme.familyorganiserbackend.entities.ShoppingList
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateShoppingListMapper :AbstractCreateMapper<ShoppingList, CreateShoppingList>()