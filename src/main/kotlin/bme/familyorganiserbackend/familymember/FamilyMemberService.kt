package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.abstracts.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class FamilyMemberService
@Autowired
constructor() : AbstractService<FamilyMember>() , UserDetailsService{
    @Autowired
    lateinit var familyMemberRepository: FamilyMemberRepository

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
        val member: FamilyMember = familyMemberRepository.findByUsername(username!!)
            ?: throw UsernameNotFoundException("Username not found")
        return User(member.username,member.password, emptyList())

    }


}