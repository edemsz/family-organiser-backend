package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.shoppinglist.ShoppingList
import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface ShoppingListRepository : AbstractRepository<ShoppingList>