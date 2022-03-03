package bme.familyorganiserbackend.familymember

import io.swagger.annotations.ApiOperation
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family_member")
class FamilyMemberController(private val service: FamilyMemberService) {

    @GetMapping
    @ApiOperation(value = " Gets all family members.")
    fun getMembers(): ResponseEntity<List<FamilyMemberPlain>> =
        ResponseEntity.ok(service.getMembers().map { it.toDto() })

    @PostMapping
    @ApiOperation(value = "Adds a family member.")
    fun addMember(@RequestBody memberDto: FamilyMemberPlain): ResponseEntity<FamilyMember> {
        val member: FamilyMember= memberDto.toFamilyMember()
        return ResponseEntity.ok(service.addMember(member))
    }

    @PutMapping("/{id}")
    @ApiOperation(value ="Updates the data of a family member.")
    fun updateMemberById(@PathVariable(value = "id") id:Long
                         , @RequestBody  member:FamilyMember) : ResponseEntity<FamilyMember>
    {
        return try{
            ResponseEntity.ok(service.updateMember(id,member))
        } catch (e: NotFoundException){
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Gets the data of the member by the ID.")
    fun getMemberById(@PathVariable(value="id") id: Long):ResponseEntity<FamilyMember>{
        val m= service.getMemberById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(m)
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Deletes the member by the ID.")
    fun deleteById(@PathVariable(value="id") id: Long){
        service.deleteMember(id)
    }


}