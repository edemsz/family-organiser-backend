package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import javax.persistence.*


@Entity
class ShoppingListItem: AbstractEntity() {

    @Column
    var price:Int=0

    @Column
    var product:String=""

    @Column
    var amount:Int=0

    @ManyToOne
    lateinit var shoppingList: ShoppingList

    @Column
    var purchased:Boolean=false
}

