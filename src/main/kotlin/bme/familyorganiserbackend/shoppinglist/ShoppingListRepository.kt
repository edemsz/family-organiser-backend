package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractRepository
import bme.familyorganiserbackend.family.Family
import org.springframework.stereotype.Repository


@Repository
interface ShoppingListRepository : AbstractRepository<ShoppingList>{
    fun findByFamily(lastname: Family): List<ShoppingList>
}