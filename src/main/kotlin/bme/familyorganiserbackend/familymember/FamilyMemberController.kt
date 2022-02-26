package bme.familyorganiserbackend.familymember

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family_member")
class FamilyMemberController(private val service: FamilyMemberService) {
    @GetMapping
    @ApiOperation(value =" Gets all family members.")
    fun GetMembers(): List<FamilyMember> = service.getMembers()

    @PostMapping
    fun AddMember( @RequestBody member: FamilyMember): ResponseEntity<FamilyMember> =
        service.addMember(member)

    @PutMapping("/{id}")
    fun UpdateTaskById( @PathVariable(value = "id") id:Long
        ,@RequestBody  member:FamilyMember)
    {
        service.putMember(id,member)
    }

    @GetMapping("/{id}")
    fun GetMemberById( @PathVariable(value="id") id: Long){
        service.getMemberById(id)
    }

    @DeleteMapping("/{id}")
    fun DeleteById(@PathVariable(value="id") id: Long){
        service.deleteMember(id)
    }


}