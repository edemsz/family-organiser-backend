package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import bme.familyorganiserbackend.familymember.FamilyRepository
import org.springframework.stereotype.Service


@Service
class FamilyService(private val repository: FamilyRepository) {
    fun getFamilies(): List<Family> = repository.findAll()

}
