package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
abstract class GetShoppingListItemMapper
    : AbstractGetMapper<ShoppingListItem, GetShoppingListItem>(){
    @AfterMapping
    fun getId(@MappingTarget target: GetShoppingListItem, source: ShoppingListItem){
        target.shoppingListId=source.shoppingList.id
    }
}