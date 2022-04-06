package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface UserRepository :AbstractRepository<User>