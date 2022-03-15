package bme.familyorganiserbackend.repositories

import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.repositories.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository : AbstractRepository<Family>

