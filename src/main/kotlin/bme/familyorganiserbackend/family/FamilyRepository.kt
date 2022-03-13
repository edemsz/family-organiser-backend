package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository : JpaRepository<Family,Long>

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository2 : AbstractRepository<Family>