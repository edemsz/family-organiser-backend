package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class GetShoppingListMapper: AbstractGetMapper<ShoppingList, ShoppingListGet>()