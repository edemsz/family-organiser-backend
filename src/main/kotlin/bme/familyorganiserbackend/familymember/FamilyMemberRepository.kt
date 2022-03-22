package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository : AbstractRepository<FamilyMember>