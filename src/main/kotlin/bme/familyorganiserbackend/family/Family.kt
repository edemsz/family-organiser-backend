package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.FamilyMember
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @OneToOne(cascade= arrayOf(CascadeType.MERGE))
    @JsonBackReference
    @JoinColumn(name="head_id", referencedColumnName = "id")
    var head:FamilyMember?=null

    @OneToMany(mappedBy = "family",cascade= arrayOf(CascadeType.MERGE))
    @JsonBackReference
    var members:List<FamilyMember>?=null

}