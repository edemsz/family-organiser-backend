package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.familymember.FamilyMemberService
import bme.familyorganiserbackend.abstracts.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyService : AbstractService<Family>(){
    @Autowired
    private lateinit var familyMemberService: FamilyMemberService
    fun addMemberToFamily(familyId:Long,memberId:Long): Family {
        val family=repository.findById(familyId)
        if(family.isEmpty)
            throw ResourceNotFoundException()
        familyMemberService.setFamilyById(memberId,family.get())
        return family.get()
    }

    override fun add(family: Family): Family {
        val f=super.add(family)
        family.head?.let { familyMemberService.setFamily(it,f) }

        family.members?.forEach {
            addMemberToFamily(f.id,it.id)
        }
        return f
    }
}