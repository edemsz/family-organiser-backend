package bme.familyorganiserbackend.familymember

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository : JpaRepository<FamilyMember,Long>