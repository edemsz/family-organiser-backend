package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.shoppinglist.item.ShoppingListItem
import java.time.LocalDate
import javax.persistence.*


@Entity
class ShoppingList() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id:Long=0

    @Column
    var fullPrice:Int=0

    @Column
    var completed:Boolean=false

    @ManyToOne
    lateinit var family:Family

    @OneToMany(mappedBy = "shoppingList", cascade= arrayOf(CascadeType.MERGE))
    var items:List<ShoppingListItem>?=null

    @Column
    lateinit var location:String

    @Column
    lateinit var completedOn:LocalDate
}