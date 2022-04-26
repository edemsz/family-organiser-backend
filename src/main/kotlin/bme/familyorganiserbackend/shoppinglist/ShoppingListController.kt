package bme.familyorganiserbackend.shoppinglist

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.shoppinglistitem.GetShoppingListItem
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shopping-list")
class ShoppingListController: AbstractController<ShoppingList, CreateShoppingList, ShoppingListGet>() {
    @Autowired
    private lateinit var shoppingListService: ShoppingListService

    @GetMapping("/by-family/{family-id}")
    @ApiOperation("Searching the lists owned by a specified family")
    fun searchByFamily(@PathVariable(value = "family-id") familyId:Long):ResponseEntity<List<ShoppingListGet>>{
        val lists=shoppingListService.getAllByFamily(familyId)
        return ResponseEntity.ok(getMapper.listOfEntitiesToDtos(lists))
    }

    @PatchMapping("/{id}/add-item/{item_id}")
    @ApiOperation(value = "Adds the shopping list shoppingitem to the shopping list")
    fun addItem(@PathVariable(value="id") listId: Long,
                @PathVariable(value="item_id") itemId: Long):ResponseEntity<ShoppingListGet>{
        val dto= getMapper.entityToDto(shoppingListService.addItem(listId,itemId))
        return ResponseEntity.ok(dto)
    }

    @PatchMapping("/{id}/remove-item/{item_id}")
    @ApiOperation(value = "Removes the shopping list shoppingitem from the shopping list")
    fun removeItem(@PathVariable(value="id") listId: Long,
                   @PathVariable(value="item_id") itemId: Long):ResponseEntity<ShoppingListGet>{
        val dto= getMapper.entityToDto(shoppingListService.removeItem(listId,itemId))
        return ResponseEntity.ok(dto)

    }


}