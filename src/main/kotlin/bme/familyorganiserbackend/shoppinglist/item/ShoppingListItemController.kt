package bme.familyorganiserbackend.shoppinglist.item

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shopping-list-item")
class ShoppingListItemController {

    @GetMapping
    @ApiOperation(value = "Gets all shopping list items.")
    fun getMembers(): ResponseEntity<List<ShoppingListItemPlain>> {
        throw NotImplementedError()
    }

    @PostMapping
    @ApiOperation(value = "Creates a new shopping list item.")
    fun addMember(@RequestBody item: CreateShoppingListItem):
            ResponseEntity<ShoppingListItemPlain> {
        throw NotImplementedError()
    }

    @PutMapping("/{id}")
    @ApiOperation(value ="Updates the data of a shopping list.")
    fun updateMemberById(@PathVariable(value = "id") id:Long
                         , @RequestBody item: CreateShoppingListItem
    ) : ResponseEntity<ShoppingListItemPlain>
    {
        throw NotImplementedError()

    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Gets the data of the item by the ID.")
    fun getMemberById(@PathVariable(value="id") id: Long): ResponseEntity<ShoppingListItemPlain> {
        throw NotImplementedError()
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Deletes the item by the ID.")
    fun deleteById(@PathVariable(value="id") id: Long):
            ResponseEntity<ShoppingListItemPlain> {
        throw NotImplementedError()
    }

    @PatchMapping("/{id}/purchase")
    @ApiOperation(value = "Purchasing the item by the ID.")
    fun purchaseById(@PathVariable(value = "id") id:Long):ResponseEntity<ShoppingListItemPlain>{
        throw NotImplementedError()
    }





}