package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.shoppinglist.ShoppingListRepository
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.springframework.beans.factory.annotation.Autowired


@Mapper(componentModel = "spring")
abstract class CreateShoppingListItemMapper
    :AbstractCreateMapper<ShoppingListItem,CreateShoppingListItem>() {
    @Autowired
    private lateinit var shoppingListRepository: ShoppingListRepository
    @AfterMapping
    fun establishRelations(@MappingTarget item: ShoppingListItem, dto: CreateShoppingListItem){
        if (dto.shoppingListId == null) return
        else item.shoppingList = shoppingListRepository.getById(dto.shoppingListId!!)
    }
}