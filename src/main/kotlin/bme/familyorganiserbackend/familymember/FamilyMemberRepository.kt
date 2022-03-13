package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository : JpaRepository<FamilyMember,Long>

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyMemberRepository2 : AbstractRepository<FamilyMember>