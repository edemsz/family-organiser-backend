package bme.familyorganiserbackend.controllers

import bme.familyorganiserbackend.dtos.CreateFamily
import bme.familyorganiserbackend.dtos.FamilyPlain
import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.services.FamilyService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family")
class FamilyController:
    AbstractController<Family, CreateFamily, FamilyPlain>()
{
    @Autowired
    lateinit var familyService: FamilyService

    @PostMapping("/{id}/leave")
    @ApiOperation(value = "Endpoint for leaving the family")
    fun leaveFamily(@PathVariable(value = "id") id: Long, @RequestParam memberId: Long): ResponseEntity<FamilyPlain> {
        throw NotImplementedError()
    }

    @PostMapping("/{id}/join")
    @ApiOperation(value = "Endpoint for joining the family")
    fun joinFamily(@PathVariable(value = "id") id: Long, @RequestParam memberId: Long): ResponseEntity<FamilyPlain> {
        val family=familyService.addMemberToFamily(id,memberId)
        return ResponseEntity.ok(getMapper.entityToDto(family))
    }



}