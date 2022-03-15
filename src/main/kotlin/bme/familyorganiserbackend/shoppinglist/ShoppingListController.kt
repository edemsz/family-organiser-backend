package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractController
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shopping-list")
class ShoppingListController: AbstractController<ShoppingList, CreateShoppingList, ShoppingListGet>() {


    @PatchMapping("/{id}/add-item/{item_id}")
    @ApiOperation(value = "Adds the shopping list item to the shopping list")
    fun addItem(@PathVariable(value="id") listId: Long,
                @PathVariable(value="item_id") itemId: Long):ResponseEntity<ShoppingListGet>{
        throw NotImplementedError()
    }

    @PatchMapping("/{id}/remove-item/{item_id}")
    @ApiOperation(value = "Removes the shopping list item from the shopping list")
    fun removeItem(@PathVariable(value="id") listId: Long,
                   @PathVariable(value="item_id") itemId: Long):ResponseEntity<ShoppingListGet>{
        throw NotImplementedError()
    }


}