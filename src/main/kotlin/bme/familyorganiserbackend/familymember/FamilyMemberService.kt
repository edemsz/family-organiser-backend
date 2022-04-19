package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.auth.*
import bme.familyorganiserbackend.basic.ResourceAlreadyExistsException
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.family.Family
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseCookie
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class FamilyMemberService
@Autowired
constructor() : AbstractService<FamilyMember>() {
    @Autowired
    lateinit var familyMemberRepository: FamilyMemberRepository
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    @Autowired
    lateinit var jwtTools: JWTTools




    override fun add(e: FamilyMember): FamilyMember {
        e.setUid()
        return super.add(e)
    }

    override fun updateById(id: Long, entity: FamilyMember): FamilyMember {
        entity.uid=repository.getById(id).uid
        return super.updateById(id, entity)
    }

    fun setFamily(member: FamilyMember, family: Family?): FamilyMember {
        if(member.family==family)
            return member
        member.family=family
        repository.save(member)
        return member
    }

    fun setFamilyById(memberId:Long,family: Family?): FamilyMember {
        val member=repository.findById(memberId)
        if(member.isEmpty)
            throw ResourceNotFoundException()
        setFamily(member.get(),family)
        return member.get()
    }


    fun setPassword(uid:String,passwordEncoded:String){
        val member=familyMemberRepository.findByUid(uid)
        member?.password=passwordEncoded
        familyMemberRepository.save(member!!)

    }

    fun register(registerData: RegistrationDTO) {
        if(familyMemberRepository.existsByUsername(registerData.username)){
            throw ResourceAlreadyExistsException()
        }
        if(!familyMemberRepository.existsByUid(registerData.uid)) {
            throw ResourceNotFoundException()
        }

        val familyMember=familyMemberRepository.findByUid(registerData.uid)
        familyMember!!.password=passwordEncoder.encode(registerData.password)
        familyMember.username=registerData.username
        this.updateById(familyMember.id,familyMember)
    }

    fun login(loginData: LoginDTO): Tokens {
        val authentication: Authentication = authenticationManager
                .authenticate(UsernamePasswordAuthenticationToken(loginData.username, loginData.password))


        SecurityContextHolder.getContext().authentication = authentication




        val user: User = authentication.principal as User
        val jwtCookie: ResponseCookie? = jwtTools.generateJwtCookie(user)
        val tokens= Tokens(jwtCookie.toString(),"")
        return tokens

    }
}

@Service
class FamilyMemberAuthService:UserDetailsService{
    @Autowired
    lateinit var familyMemberRepository: FamilyMemberRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val member=familyMemberRepository.findByUsername(username!!)?: throw UsernameNotFoundException("User not found")
        return buildUserFromMember(member)
    }
    private fun buildUserFromMember(member: FamilyMember): User {
        return User().fromMember(member)
    }
}