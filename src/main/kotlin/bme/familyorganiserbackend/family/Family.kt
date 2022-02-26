package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.FamilyMember
import javax.persistence.*


@Entity
class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0

    @Column(nullable=false)
    lateinit var name:String

    @OneToOne()
    @JoinColumn(name="head_id", referencedColumnName = "id")
    lateinit var head:FamilyMember

    @OneToMany(mappedBy = "family")
    lateinit var members:List<FamilyMember>

}