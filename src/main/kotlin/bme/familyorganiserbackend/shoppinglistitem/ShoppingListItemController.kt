package bme.familyorganiserbackend.shoppinglistitem

import bme.familyorganiserbackend.abstracts.AbstractController
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shopping-list-item")
class ShoppingListItemController : AbstractController<ShoppingListItem, CreateShoppingListItem, GetShoppingListItem>() {
    @Autowired
    private lateinit var shoppingListItemService: ShoppingListItemService

    @PatchMapping("/{id}/purchase")
    @ApiOperation(value = "Purchasing the shoppingitem by the ID.")
    fun purchaseById(@PathVariable(value = "id") id:Long):ResponseEntity<GetShoppingListItem>{
        val dto=getMapper.entityToDto(shoppingListItemService.purchase(id))
        return ResponseEntity.ok(dto)
    }





}