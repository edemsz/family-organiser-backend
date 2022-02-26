package bme.familyorganiserbackend.familymember

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class FamilyMemberService(private val repository: FamilyMemberRepository) {
    fun getMembers(): List<FamilyMember> = repository.findAll()
    fun addMember(member: FamilyMember): ResponseEntity<FamilyMember> =
        ResponseEntity.ok(repository.save(member))

    fun getMemberById(id: Long): ResponseEntity<FamilyMember> =
        repository.findById(id).map { m ->
            ResponseEntity.ok(m)
        }.orElse(ResponseEntity.notFound().build())

    fun putMember(id: Long, newMember: FamilyMember): ResponseEntity<FamilyMember> =
        repository.findById(id).map { m ->
            val updatedMember: FamilyMember = FamilyMember.fromFamilyMember(m)
            ResponseEntity.ok().body(repository.save(updatedMember))
        }.orElse(ResponseEntity.notFound().build())

    fun deleteMember(id: Long): ResponseEntity<Void> =
        repository.findById(id).map { member ->
            repository.delete(member)
            ResponseEntity<Void>(HttpStatus.ACCEPTED)
        }.orElse(ResponseEntity.notFound().build())


}