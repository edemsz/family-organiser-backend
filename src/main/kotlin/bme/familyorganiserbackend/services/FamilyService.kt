package bme.familyorganiserbackend.services

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.entities.Family
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyService() : AbstractService<Family>(){
    @Autowired
    private lateinit var familyMemberService: FamilyMemberService
    fun addMemberToFamily(familyId:Long,memberId:Long): Family {
        val family=repository.findById(familyId)
        if(family.isEmpty)
            throw ResourceNotFoundException()
        familyMemberService.setFamilyById(memberId,family.get())
        return family.get()
    }
}