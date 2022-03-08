package bme.familyorganiserbackend.family

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family")
class FamilyController(private val service: FamilyService) {
    @GetMapping
    @ApiOperation(value = " Gets all families.")
    fun getFamilies(): ResponseEntity<List<FamilyPlain>> {
        throw NotImplementedError()
    }
    @PostMapping
    @ApiOperation(value = "Adds a family.")
    fun addMember(@RequestBody family: CreateFamily): ResponseEntity<FamilyPlain> {
        throw NotImplementedError()
    }

    @PutMapping("/{id}")
    @ApiOperation(value ="Updates the data of a family.")
    fun updateMemberById(@PathVariable(value = "id") id:Long
                         , @RequestBody family: CreateFamily
    ) : ResponseEntity<FamilyPlain>
    {
        throw NotImplementedError()
    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Gets the data of the family by the ID.")
    fun getFamilyById(@PathVariable(value="id") id: Long):ResponseEntity<FamilyPlain>{
        throw NotImplementedError()
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Deletes the family with the ID.")
    fun deleteById(@PathVariable(value="id") id: Long):ResponseEntity<FamilyPlain>{
        throw NotImplementedError()
    }

    @PostMapping("/{id}/leave")
    @ApiOperation(value = "Endpoint for leaving the family")
    fun leaveFamily(@PathVariable(value = "id") id:Long,@RequestParam memberId:Long):ResponseEntity<FamilyPlain>{
        throw NotImplementedError()
    }

    @PostMapping("/{id}/join")
    @ApiOperation(value = "Endpoint for joining the family")
    fun joinFamily(@PathVariable(value = "id") id:Long,@RequestParam memberId:Long):ResponseEntity<FamilyPlain>{
        throw NotImplementedError()
    }
    @PostMapping("/{id}/add_member")
    @ApiOperation(value = "Endpoint for joining the family")
    fun addToFamily(@PathVariable(value = "id") id:Long,@RequestParam memberId:Long):ResponseEntity<FamilyPlain>{
        throw NotImplementedError()
    }



}