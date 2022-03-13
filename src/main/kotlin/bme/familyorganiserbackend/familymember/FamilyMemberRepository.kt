package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.DAO
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository : DAO<FamilyMember>