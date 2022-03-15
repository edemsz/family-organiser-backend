package bme.familyorganiserbackend.entities

import javax.persistence.*


@MappedSuperclass
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = -1

    companion object {
        var name:String="entity"
    }


}
