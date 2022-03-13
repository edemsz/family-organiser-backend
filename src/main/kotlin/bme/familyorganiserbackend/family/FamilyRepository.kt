package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.DAO
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface FamilyRepository : DAO<Family>