package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.abstracts.AbstractRepository
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyService() : AbstractService<Family>(){
    @Autowired
    private lateinit var familyMemberService: FamilyMemberService
    fun addMemberToFamily(familyId:Long,memberId:Long):Family{
        val family=repository.findById(familyId)
        if(family.isEmpty)
            throw ResourceNotFoundException()
        familyMemberService.setFamilyById(memberId,family.get())
        return family.get()
    }
}