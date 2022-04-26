package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.shoppinglist.ShoppingListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class ShoppingListItemService : AbstractService<ShoppingListItem>() {
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
        shoppingListService.calculatePurchase(item.shoppingList)
        return item
    }

}