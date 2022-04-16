package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO
import bme.familyorganiserbackend.shoppinglist.ShoppingList

data class CreateShoppingList (
    var familyId: Long=0,

    var location:String
    ): AbstractCreateDTO<ShoppingList>