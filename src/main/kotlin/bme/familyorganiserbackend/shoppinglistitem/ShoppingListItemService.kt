package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.shoppinglist.ShoppingList
import bme.familyorganiserbackend.shoppinglist.ShoppingListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class ShoppingListItemService : AbstractService<ShoppingListItem>() {
    override fun add(e: ShoppingListItem): ShoppingListItem {
        val item= super.add(e)
        calculateListPrice(e)
        return item
    }




    override fun updateById(id: Long, entity: ShoppingListItem): ShoppingListItem {
        val i=super.updateById(id, entity)
        calculateListPrice(entity)
        return i
    }



    override fun delete(entity: ShoppingListItem?): Boolean {
        val success=super.delete(entity)
        calculateListPrice(entity!!)
        return success
    }
    @Autowired
    private lateinit var shoppingListService: ShoppingListService
    @PostConstruct
    fun setItemService(){
        shoppingListService.shoppingListItemService=this
    }

    fun purchase(id: Long): ShoppingListItem {
        val item=getById(id)?:throw ResourceNotFoundException()
        return purchase(item)
    }

    fun purchase(item:ShoppingListItem):ShoppingListItem{
        item.purchased=true
        updateById(item.id,item)
        item.shoppingList?.let { shoppingListService.calculatePurchase(it) }
        return item
    }
    fun calculateListPrice(item:ShoppingListItem): ShoppingList? {
        return item.shoppingList?.let { shoppingListService.calculatePrice(it) }
    }



}