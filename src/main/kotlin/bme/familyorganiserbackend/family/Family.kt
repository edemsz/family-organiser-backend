package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import bme.familyorganiserbackend.familymember.FamilyMember
import javax.persistence.*


@Entity
@Table(name = "FAMILY")
class Family() : AbstractEntity() {
    constructor(name: String, head: FamilyMember? = null, members: MutableList<FamilyMember>? = null) : this() {
        this.name = name
        this.head = head
        this.members = members ?: mutableListOf()
    }


    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = true)
    var code: String = "egyed1K0d"

    @OneToOne
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    var head: FamilyMember? = null

    @OneToMany(mappedBy = "family")
    var members:MutableList<FamilyMember>?=null

    @OneToMany(mappedBy = "family", cascade = arrayOf(CascadeType.MERGE))
    var shoppingLists: List<ShoppingList>? = null


}