package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.abstracts.AbstractRepository
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyService() : AbstractService<Family>(){
    @Autowired
    private lateinit var familyMemberRepository:FamilyMemberRepository
    fun addMemberToFamily(familyId:Long,memberId:Long):Family{
        val f=repository.getById(familyId)
        val member=familyMemberRepository.findById(memberId)
        if(f==null || member.isEmpty)
            throw ResourceNotFoundException()
        member.get().family=f
        familyMemberRepository.save(member.get())
        return f
    }
}