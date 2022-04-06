package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractEmptyController
import bme.familyorganiserbackend.familymember.FamilyMember
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthController :AbstractEmptyController<FamilyMember>() {
    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var encoder: PasswordEncoder

    @Autowired
    lateinit var jwtTools: JWTTools

}