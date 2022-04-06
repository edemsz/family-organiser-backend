package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate
import javax.persistence.Entity

@Entity
data class User(
    private var username: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    private var password: String? = null,
    var email: String? = null,
    var uid:String?=null,
    var lastPasswordResetDate: LocalDate? = null) : AbstractEntity(),UserDetails {

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
}