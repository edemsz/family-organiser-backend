package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.shoppinglist.item.ShoppingListItemPlain

data class ShoppingListGet (
    var id:Long,

    var fullPrice:Int,

    var completed:Boolean=false,

    var familyId: Long,

    var items:List<ShoppingListItemPlain>?= emptyList()

):AbstractGetDTO<ShoppingList>()