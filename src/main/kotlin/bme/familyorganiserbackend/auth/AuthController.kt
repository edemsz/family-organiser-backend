package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import bme.familyorganiserbackend.familymember.FamilyMemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthController  {
    @Autowired
    lateinit var familyMemberService: FamilyMemberService
    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var familyMemberRepository: FamilyMemberRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var encoder: PasswordEncoder

    @Autowired
    lateinit var jwtTools: JWTTools

}