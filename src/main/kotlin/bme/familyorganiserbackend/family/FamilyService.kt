package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import bme.familyorganiserbackend.family.FamilyRepository
import org.springframework.stereotype.Service


@Service
class FamilyService(private val repository: FamilyRepository) : AbstractService<Family>()