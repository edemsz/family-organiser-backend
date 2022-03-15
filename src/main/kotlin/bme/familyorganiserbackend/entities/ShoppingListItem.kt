package bme.familyorganiserbackend.entities

import javax.persistence.*


@Entity
class ShoppingListItem() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id:Long=0

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

