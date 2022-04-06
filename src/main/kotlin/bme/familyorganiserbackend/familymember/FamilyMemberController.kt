package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.auth.*
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/family-member")
open class FamilyMemberController:
    AbstractController<FamilyMember, CreateFamilyMember, FamilyMemberGet>()
 {
     @Autowired
     lateinit var authController: AuthController


     @PostMapping("/sign-up")
    @ApiOperation("Sign up method for users")
    fun register(@RequestBody registerData: RegistrationDTO): ResponseEntity<Tokens> {
        throw NotImplementedError()
    }

    @PostMapping("/login")
    @ApiOperation("Login method for users")
    fun login(@RequestBody loginData: LoginDTO): ResponseEntity<String> {
        val authentication: Authentication = authController.authenticationManager
            .authenticate(UsernamePasswordAuthenticationToken(loginData.username, loginData.password))

        SecurityContextHolder.getContext().authentication = authentication

        val user: User = authentication.principal as User
        val jwtCookie: ResponseCookie? = authController.jwtTools.generateJwtCookie(user)
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
            .body(user.uid)
    }


}