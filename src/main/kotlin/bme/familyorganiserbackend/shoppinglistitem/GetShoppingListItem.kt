package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractGetDTO

data class GetShoppingListItem (
    var id:Long=0,

    var price:Int=0,

    var product:String="",

    var amount:Int=0,

    var shoppingListId: Long=0

):AbstractGetDTO<ShoppingListItem>