package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateShoppingListMapper :AbstractCreateMapper<ShoppingList,CreateShoppingList>()