package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.auth.RegistrationDTO
import bme.familyorganiserbackend.auth.User
import bme.familyorganiserbackend.auth.UserMapper
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.family.Family
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class FamilyMemberService
@Autowired
constructor() : AbstractService<FamilyMember>() , UserDetailsService{
    @Autowired
    lateinit var familyMemberRepository: FamilyMemberRepository
    @Autowired
    @Lazy
    lateinit var passwordEncoder:PasswordEncoder
    @Autowired
    @Lazy
    lateinit var userMapper: UserMapper



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

    override fun loadUserByUsername(username: String?): UserDetails {
        val member=familyMemberRepository.findByUsername(username!!)?: throw UsernameNotFoundException("User not found")
        return buildUserFromMember(member)

    }
    private fun buildUserFromMember(member: FamilyMember): User {
        return userMapper.entityToDto(member)
    }

    fun setPassword(uid:String,passwordEncoded:String){
        val member=familyMemberRepository.findByUid(uid)
        member?.password=passwordEncoded
        familyMemberRepository.save(member!!)

    }

    fun register(registerData: RegistrationDTO) {
        val familyMember=familyMemberRepository.findByUid(registerData.uid)
        familyMember!!.password=passwordEncoder.encode(registerData.password)
        familyMember.username=registerData.username
        this.updateById(familyMember.id,familyMember)
    }


}