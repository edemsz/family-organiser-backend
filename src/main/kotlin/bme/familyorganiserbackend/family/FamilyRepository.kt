package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository : AbstractRepository<Family>

