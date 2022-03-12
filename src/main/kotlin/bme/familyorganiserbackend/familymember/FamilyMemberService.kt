package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.ResourceNotFoundException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
open class FamilyMemberService(private val repository: FamilyMemberRepository) {
    fun getMembers(): List<FamilyMember> = repository.findAll()

    fun addMember(member: FamilyMember):FamilyMember {
         return repository.save(member.setUid())
    }

    fun getMemberById(id: Long): FamilyMember? =
        repository.findById(id).orElse(null)

    fun updateMember(id: Long, newMember: FamilyMember): FamilyMember {
        val persistedMember=repository.getById(id)
        if(id!=persistedMember.id){
            throw ResourceNotFoundException()
        }
        return repository.save(newMember)


    }


    fun deleteMember(id: Long): Boolean {
        return repository.findById(id).map { member ->
            repository.delete(member)
            true
        }.orElse(false)

    }



}