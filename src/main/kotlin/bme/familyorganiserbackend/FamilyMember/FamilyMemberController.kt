package bme.familyorganiserbackend.FamilyMember

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family_member")
class FamilyMemberController(private val service: FamilyMemberService) {
    @GetMapping
    fun getMembers(): List<FamilyMember> = service.getMembers()

    @PostMapping
    fun addMember( @RequestBody member: FamilyMember): ResponseEntity<FamilyMember> =
        service.addMember(member)

    @PutMapping("/{id}")
    fun updateTaskById( @PathVariable(value = "id") id:Long
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