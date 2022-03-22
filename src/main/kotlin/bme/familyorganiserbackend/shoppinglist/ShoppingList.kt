package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.shoppinglistitem.ShoppingListItem
import bme.familyorganiserbackend.family.Family
import java.time.LocalDate
import javax.persistence.*


@Entity
class ShoppingList: AbstractEntity() {
    @Column
    var fullPrice:Int=0

    @Column
    var completed:Boolean=false

    @ManyToOne
    lateinit var family: Family

    @OneToMany(mappedBy = "shoppingList", cascade= arrayOf(CascadeType.MERGE))
    var items:List<ShoppingListItem>?=null

    @Column
    lateinit var location:String

    @Column
    lateinit var completedOn:LocalDate
}