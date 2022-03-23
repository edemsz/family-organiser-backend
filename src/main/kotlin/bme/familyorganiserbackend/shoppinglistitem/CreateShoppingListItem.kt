package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractCreateDTO

data class CreateShoppingListItem (
    var price:Int=0,

    var product:String="",

    var amount:Int=0,

    var shoppingListId: Long?=0
): AbstractCreateDTO<ShoppingListItem>()