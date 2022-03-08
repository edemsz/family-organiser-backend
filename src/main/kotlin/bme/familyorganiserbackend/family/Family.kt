package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*


@Entity
@Table(name="FAMILY")
class Family() {
    constructor(name:String,head:FamilyMember?=null,members:List<FamilyMember>?=null) : this() {
        this.name=name
        this.head=head
        this.members=members ?: listOf()
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0

    @Column(nullable=false)
    lateinit var name:String

    @Column(nullable=true)
    var code:String="egyed1K0d"

    @OneToOne(cascade= arrayOf(CascadeType.MERGE))
    @JsonBackReference
    @JoinColumn(name="head_id", referencedColumnName = "id")
    var head:FamilyMember?=null

    @OneToMany(mappedBy = "family",cascade= arrayOf(CascadeType.MERGE))
    @JsonBackReference
    var members:List<FamilyMember>?=null

    @OneToMany(mappedBy = "family", cascade= arrayOf(CascadeType.MERGE))
    var shoppingLists:List<ShoppingList>? =null

    fun toPlain():FamilyPlain{
        val familyPlain =FamilyPlain()
        familyPlain.name=this.name
        familyPlain.id=this.id
        familyPlain.head=this.head?.toPlain()
        familyPlain.members=this.members?.map { it.toPlain() }
        return familyPlain
    }

}