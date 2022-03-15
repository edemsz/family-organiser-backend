package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*


@Entity
@Table(name = "FAMILY")
class Family() : AbstractEntity() {
    constructor(name: String, head: FamilyMember? = null, members: List<FamilyMember>? = null) : this() {
        this.name = name
        this.head = head
        this.members = members ?: listOf()
    }


    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = true)
    var code: String = "egyed1K0d"

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    var head: FamilyMember? = null

    @OneToMany(mappedBy = "family")
    @JsonBackReference
    var members:List<FamilyMember>?=null

    @OneToMany(mappedBy = "family", cascade = arrayOf(CascadeType.MERGE))
    var shoppingLists: List<ShoppingList>? = null


}