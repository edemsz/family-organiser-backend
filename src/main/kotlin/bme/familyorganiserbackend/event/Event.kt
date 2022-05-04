package bme.familyorganiserbackend.event

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.family.Family
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Event : AbstractEntity() {
    @Column(nullable = false)
    lateinit var name: String
    @Column(nullable = false)
    lateinit var place: String


    @Column(nullable = false)
    lateinit var start: LocalDateTime
    @Column(nullable = false)
    lateinit var end: LocalDateTime


    @ManyToOne
    @JoinColumn(name="family_id", referencedColumnName = "id")
    var family: Family?=null

}