package bme.familyorganiserbackend.repositories

import bme.familyorganiserbackend.entities.FamilyMember
import bme.familyorganiserbackend.repositories.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository : AbstractRepository<FamilyMember>