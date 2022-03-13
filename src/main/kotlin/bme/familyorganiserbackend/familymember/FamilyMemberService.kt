package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
open class FamilyMemberService
@Autowired
constructor(private val repository: FamilyMemberRepository) {
    fun getMembers(): List<FamilyMember> = repository.findAll()

    fun addMember(member: FamilyMember): FamilyMember {
        return repository.save(member.setUid())
    }

    fun getMemberById(id: Long): FamilyMember? =
        repository.findById(id).orElse(null)

    fun updateMember(id: Long, newMember: FamilyMember): FamilyMember {
        val persistedMember = repository.getById(id)
        if (id != persistedMember.id) {
            throw ResourceNotFoundException()
        }
        newMember.id = id
        newMember.uid = persistedMember.uid
        return repository.save(newMember)


    }


    fun deleteMember(id: Long): Boolean {
        return repository.findById(id).map { member ->
            repository.delete(member)
            true
        }.orElse(false)

    }


}