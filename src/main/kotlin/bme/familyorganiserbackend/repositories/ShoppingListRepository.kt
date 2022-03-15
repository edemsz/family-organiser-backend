package bme.familyorganiserbackend.repositories

import bme.familyorganiserbackend.entities.ShoppingList
import bme.familyorganiserbackend.repositories.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface ShoppingListRepository : AbstractRepository<ShoppingList>