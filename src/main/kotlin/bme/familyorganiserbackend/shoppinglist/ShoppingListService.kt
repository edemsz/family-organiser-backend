package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.family.FamilyService
import bme.familyorganiserbackend.shoppinglistitem.ShoppingListItem
import bme.familyorganiserbackend.shoppinglistitem.ShoppingListItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class ShoppingListService : AbstractService<ShoppingList>() {
    lateinit var shoppingListItemService: ShoppingListItemService
    @Autowired
    private lateinit var shoppingListRepository: ShoppingListRepository
    @Autowired
    private lateinit var familyService: FamilyService

    fun addItem(listId: Long, itemId: Long):ShoppingList {
        val list:ShoppingList=this.getById(listId)?:throw ResourceNotFoundException()
        val item:ShoppingListItem=shoppingListItemService.getById(itemId) ?: throw ResourceNotFoundException()
        list.items += item
        item.shoppingList=list
        updateById(list.id,list)
        return list
    }

    fun removeItem(listId: Long, itemId: Long):ShoppingList {
        val list:ShoppingList=this.getById(listId)?:throw ResourceNotFoundException()
        val item:ShoppingListItem=shoppingListItemService.getById(itemId) ?: throw ResourceNotFoundException()
        item.shoppingList=null
        list.items -= item
        updateById(list.id,list)
        return list
    }

    fun calculatePurchase(shoppingList: ShoppingList):ShoppingList {
        if(shoppingList.completed)
            return shoppingList
        for (item in shoppingList.items)
            if(!item.purchased)
                return shoppingList
        shoppingList.completed=true
        shoppingList.completedOn= LocalDate.now()
        updateById(shoppingList.id,shoppingList)
        return shoppingList
    }

    fun calculatePrice(shoppingList:ShoppingList):ShoppingList{
        shoppingList.fullPrice=shoppingList.items.sumOf { it.price*it.amount }
        updateById(shoppingList.id,shoppingList)
        return shoppingList
    }

    fun getAllByFamily(familyId: Long):List<ShoppingList>{
        val f=familyService.getById(familyId)!!
        return shoppingListRepository.findByFamily(f)
    }

}