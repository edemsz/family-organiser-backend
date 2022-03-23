package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.shoppinglist.CreateShoppingList
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class CreateShoppingListMapper :AbstractCreateMapper<ShoppingList, CreateShoppingList>(){

}