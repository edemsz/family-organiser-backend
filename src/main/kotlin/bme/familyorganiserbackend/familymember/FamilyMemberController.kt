package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.mapper.CreateFamilyMemberMapper
import bme.familyorganiserbackend.familymember.mapper.GetFamilyMemberMapper
import bme.familyorganiserbackend.security.LoginDTO
import bme.familyorganiserbackend.security.Tokens
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/family-member")
class FamilyMemberController
    (
        private val service: FamilyMemberService,
        private val getMapper:GetFamilyMemberMapper,
        private val createMapper:CreateFamilyMemberMapper,
    ) {

    @GetMapping
    @ApiOperation(value = " Gets all family members.")
    fun getMembers(): ResponseEntity<List<FamilyMemberGet>> {
        val members: List<FamilyMember> = service.getMembers()
        val memberDtos = getMapper.listOfEntitiesToDtos(members)
        return ResponseEntity.ok(memberDtos)
    }

    @PostMapping
    @ApiOperation(value = "Adds a family member.")
    fun addMember(@RequestBody memberDto: CreateFamilyMember): ResponseEntity<FamilyMemberGet> {

        try {
            val member = createMapper.dtoToEntity(memberDto)
            val addedMember = service.addMember(member)
            val getDTO = getMapper.entityToDto(addedMember)
            return ResponseEntity.ok(getDTO)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates the data of a family member.")
    fun updateMemberById(
        @PathVariable(value = "id") id: Long, @RequestBody memberDto: CreateFamilyMember
    ): ResponseEntity<FamilyMemberGet> {

        try {
            val member = createMapper.dtoToEntity(memberDto)

            val addedMember = service.updateMember(id, member)

            val getDTO = getMapper.entityToDto(addedMember)

            return ResponseEntity.ok(getDTO)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Gets the data of the member by the ID.")
    fun getMemberById(@PathVariable(value = "id") id: Long): ResponseEntity<FamilyMemberGet> {
        try {
            return ResponseEntity.ok(getMapper.entityToDto(service.getMemberById(id)!!))
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }

    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes the member by the ID.")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<FamilyMemberGet> {
        try {
            val memberDeleted = getMapper.entityToDto(service.getMemberById(id)!!)
            service.deleteMember(id)
            return ResponseEntity.ok(memberDeleted)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }

    }

    @PostMapping("/register")
    @ApiOperation("Sign up method for users")
    fun register(@RequestBody loginData: LoginDTO): ResponseEntity<Tokens> {
        throw NotImplementedError()
    }

    @PostMapping("/login")
    @ApiOperation("Login method for users")
    fun login(@RequestBody loginData: LoginDTO) {
        throw NotImplementedError()
    }


}