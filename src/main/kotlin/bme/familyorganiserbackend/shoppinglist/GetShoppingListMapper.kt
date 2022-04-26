package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.shoppinglistitem.GetShoppingListItemMapper
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring", uses = [GetShoppingListItemMapper::class])
abstract class GetShoppingListMapper: AbstractGetMapper<ShoppingList, ShoppingListGet>(){
    @AfterMapping
    fun getId(@MappingTarget dto:ShoppingListGet,list:ShoppingList){
        dto.familyId=list.family.id
    }
}