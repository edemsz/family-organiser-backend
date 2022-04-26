package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.shoppinglistitem.GetShoppingListItem
import java.time.LocalDate

data class ShoppingListGet (
    var id:Long,

    var fullPrice:Int,

    var completed:Boolean=false,

    var familyId: Long,

    var items:List<GetShoppingListItem>?= emptyList(),

    var location:String,

    var completedOn: LocalDate?


):AbstractGetDTO<ShoppingList>