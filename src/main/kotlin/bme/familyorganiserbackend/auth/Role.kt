package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractEntity
import javax.persistence.Entity

@Entity
class Role: AbstractEntity() {
    lateinit var role:ERole
}