package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository


@Repository
interface ShoppingListRepository : AbstractRepository<ShoppingList>{
    fun findByFamily(lastname: bme.familyorganiserbackend.family.Family): List<ShoppingList>
}