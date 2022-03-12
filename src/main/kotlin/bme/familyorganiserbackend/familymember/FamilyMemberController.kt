package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.dto.FamilyMemberPlain
import bme.familyorganiserbackend.familymember.mapper.PlainFamilyMemberMapper
import bme.familyorganiserbackend.security.LoginDTO
import bme.familyorganiserbackend.security.Tokens
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family-member")
class FamilyMemberController(private val service: FamilyMemberService) {
    @GetMapping
    @ApiOperation(value = " Gets all family members.")
    fun getMembers(): ResponseEntity<List<FamilyMemberPlain?>> {
        val m= PlainFamilyMemberMapper.INSTANCE

        val members:List<FamilyMember> =service.getMembers()
        val memberDtos=members.map { m.entityToPlain(it) }
        return ResponseEntity.ok(memberDtos)
    }

    @PostMapping
    @ApiOperation(value = "Adds a family member.")
    fun addMember(@RequestBody memberDto: CreateFamilyMember): ResponseEntity<FamilyMemberGet> {
        throw NotImplementedError()

        /*val member=createMapper.CreateDTOToEntity(memberDto)
        val addedMember=service.addMember(member)
        val getDTO=getMapper.entityToGet(addedMember)
        return ResponseEntity.ok(getDTO)*/
    }

    @PutMapping("/{id}")
    @ApiOperation(value ="Updates the data of a family member.")
    fun updateMemberById(@PathVariable(value = "id") id:Long
                         , @RequestBody  member: CreateFamilyMember
    ) : ResponseEntity<FamilyMemberGet>
    {
        throw NotImplementedError()

    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Gets the data of the member by the ID.")
    fun getMemberById(@PathVariable(value="id") id: Long):ResponseEntity<FamilyMemberGet>{
        throw NotImplementedError()
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Deletes the member by the ID.")
    fun deleteById(@PathVariable(value="id") id: Long):ResponseEntity<FamilyMemberPlain>{
        throw NotImplementedError()
    }

    @PostMapping("/register")
    @ApiOperation("Sign up method for users")
    fun register(@RequestBody loginData:LoginDTO):ResponseEntity<Tokens>{
        throw NotImplementedError()
    }

    @PostMapping("/login")
    @ApiOperation("Login method for users")
    fun login(@RequestBody loginData:LoginDTO){
        throw NotImplementedError()
    }




}