package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractEntity
import bme.familyorganiserbackend.abstracts.AbstractGetDTO
import bme.familyorganiserbackend.familymember.FamilyMember
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate

class User (
    private var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    private var password: String? = null,
    var email: String? = null,
    var uid:String?=null,
    var lastPasswordResetDate: LocalDate? = null) : AbstractEntity(),AbstractGetDTO<FamilyMember>,UserDetails {

    @Transient
    var grantedAuthorities: MutableCollection<out GrantedAuthority>? = null

    override fun getAuthorities() = when (grantedAuthorities) {
        null -> mutableListOf()
        else -> grantedAuthorities!!
    }

    override fun getPassword()=password

    override fun getUsername()=username

    override fun isAccountNonExpired()=true

    override fun isAccountNonLocked()=true

    override fun isCredentialsNonExpired()=true

    override fun isEnabled() =true

    fun setUsername(username: String?) {
        this.username = username
    }
    fun setPassword(password:String?){
        this.password=password
    }
    fun fromMember(member:FamilyMember):User{
        this.password=member.password
        this.username=member.username
        this.email=member.email
        this.firstName=member.firstName
        this.lastName=member.lastName
        this.uid=member.uid
        return this
    }
}