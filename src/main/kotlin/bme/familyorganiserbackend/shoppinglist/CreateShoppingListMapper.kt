package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.family.FamilyService
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring")
abstract class CreateShoppingListMapper :AbstractCreateMapper<ShoppingList, CreateShoppingList>(){
    @Autowired
    private lateinit var familyService: FamilyService
    @AfterMapping
    fun fillReferences(@MappingTarget target: ShoppingList, source: CreateShoppingList){
        target.family= familyService.getById(source.familyId)!!
    }

}