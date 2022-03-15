package bme.familyorganiserbackend.controllers

import bme.familyorganiserbackend.dtos.CreateFamilyMember
import bme.familyorganiserbackend.dtos.FamilyMemberGet
import bme.familyorganiserbackend.dtos.LoginDTO
import bme.familyorganiserbackend.dtos.Tokens
import bme.familyorganiserbackend.entities.FamilyMember
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/family-member")
class FamilyMemberController:
    AbstractController<FamilyMember, CreateFamilyMember, FamilyMemberGet>()
     {

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