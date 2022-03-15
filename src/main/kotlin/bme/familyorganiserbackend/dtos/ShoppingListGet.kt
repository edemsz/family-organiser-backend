package bme.familyorganiserbackend.dtos

import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.entities.ShoppingList
import bme.familyorganiserbackend.mappers.ShoppingListItemPlain

data class ShoppingListGet (
    var id:Long,

    var fullPrice:Int,

    var completed:Boolean=false,

    var familyId: Long,

    var items:List<ShoppingListItemPlain>?= emptyList()

):AbstractGetDTO<ShoppingList>()