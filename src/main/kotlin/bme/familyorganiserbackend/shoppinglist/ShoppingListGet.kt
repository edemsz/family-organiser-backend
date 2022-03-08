package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.shoppinglist.item.ShoppingListItemPlain

class ShoppingListGet {
    var id:Long=0

    var fullPrice:Int=0

    var completed:Boolean=false

    var familyId: Long=0

    var items:List<ShoppingListItemPlain>?= emptyList()

}