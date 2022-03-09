package bme.familyorganiserbackend.shoppinglist

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shopping-list")
class ShoppingListController {
    @GetMapping
    @ApiOperation(value = "Gets all shopping lists.")
    fun getMembers(): ResponseEntity<List<ShoppingListGet>> {
        throw NotImplementedError()
    }

    @PostMapping
    @ApiOperation(value = "Creates a new shopping list.")
    fun addMember(@RequestBody list: CreateShoppingList): ResponseEntity<ShoppingListGet> {
        throw NotImplementedError()
    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Gets the data of the shopping list by the ID.")
    fun getMemberById(@PathVariable(value="id") id: Long): ResponseEntity<ShoppingListGet> {
        throw NotImplementedError()
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Deletes the shopping list by the ID.")
    fun deleteById(@PathVariable(value="id") id: Long): ResponseEntity<ShoppingListGet> {
        throw NotImplementedError()
    }

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