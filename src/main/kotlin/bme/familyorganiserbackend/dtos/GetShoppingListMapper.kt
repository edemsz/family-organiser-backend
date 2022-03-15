package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.entities.ShoppingList
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class GetShoppingListMapper: AbstractGetMapper<ShoppingList, ShoppingListGet>()