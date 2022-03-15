package bme.familyorganiserbackend.services

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.entities.FamilyMember
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyMemberService
@Autowired
constructor() : AbstractService<FamilyMember>() {
    override fun add(e: FamilyMember): FamilyMember {
        e.setUid()
        return super.add(e)
    }

    override fun updateById(id: Long, entity: FamilyMember): FamilyMember {
        entity.uid=repository.getById(id).uid
        return super.updateById(id, entity)
    }

    fun setFamily(member: FamilyMember, family: Family?): FamilyMember {
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



}