package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.family.dto.CreateFamily
import bme.familyorganiserbackend.family.dto.FamilyPlain
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family")
class FamilyController:
    AbstractController<Family, CreateFamily, FamilyPlain>()
   {

    @PostMapping("/{id}/leave")
    @ApiOperation(value = "Endpoint for leaving the family")
    fun leaveFamily(@PathVariable(value = "id") id: Long, @RequestParam memberId: Long): ResponseEntity<FamilyPlain> {
        throw NotImplementedError()
    }

    @PostMapping("/{id}/join")
    @ApiOperation(value = "Endpoint for joining the family")
    fun joinFamily(@PathVariable(value = "id") id: Long, @RequestParam memberId: Long): ResponseEntity<FamilyPlain> {
        throw NotImplementedError()
    }

    @PostMapping("/{id}/add_member")
    @ApiOperation(value = "Endpoint for joining the family")
    fun addToFamily(@PathVariable(value = "id") id: Long, @RequestParam memberId: Long): ResponseEntity<FamilyPlain> {
        throw NotImplementedError()
    }


}