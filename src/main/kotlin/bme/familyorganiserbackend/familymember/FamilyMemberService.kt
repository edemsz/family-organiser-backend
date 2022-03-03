package bme.familyorganiserbackend.familymember

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service


@Service
class FamilyMemberService(private val repository: FamilyMemberRepository) {
    fun getMembers(): List<FamilyMember> = repository.findAll()

    fun addMember(member: FamilyMember): FamilyMember = repository.save(member)

    fun getMemberById(id: Long): FamilyMember? =
        repository.findById(id).orElse(null)

    fun updateMember(id: Long, newMember: FamilyMember): FamilyMember {
        if(repository.existsById(id)){
            return repository.save(FamilyMember.fromFamilyMember(newMember))
        }
        throw NotFoundException()
    }


    fun deleteMember(id: Long): Boolean {
        return repository.findById(id).map { member ->
            repository.delete(member)
            true
        }.orElse(false)

    }



}