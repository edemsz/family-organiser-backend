package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.entities.ShoppingList

data class CreateShoppingList (
    var familyId: Long=0,

    var location:String
    ): AbstractCreateDTO<ShoppingList>()