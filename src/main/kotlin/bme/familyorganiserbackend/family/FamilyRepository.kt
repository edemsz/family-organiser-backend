package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.Family
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository : JpaRepository<Family,Long>