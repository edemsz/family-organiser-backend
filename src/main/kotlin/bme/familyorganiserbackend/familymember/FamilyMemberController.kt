package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.auth.*
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/family-member")
open class FamilyMemberController:
    AbstractController<FamilyMember, CreateFamilyMember, FamilyMemberGet>()
 {
     @Autowired
     lateinit var authController: AuthController
     @Autowired
     lateinit var jwtTools: JWTTools


     @GetMapping("/me")
     @ApiOperation("Gets the family member of the current user")
     fun getMe(@RequestHeader headers: HttpHeaders){
         val authHeader:String= headers["Authorization"].toString()
         println(headers["Authorization"])
         println(headers.toString())
         println(jwtTools.getUserNameFromJwtToken(authHeader))
     }




     @PostMapping("/sign-up")
    @ApiOperation("Sign up method for users")
    fun register(@RequestBody registerData: RegistrationDTO): ResponseEntity<Tokens> {
        if (authController.familyMemberRepository.existsByUsername(registerData.username)) {
             throw ResponseStatusException(HttpStatus.CONFLICT,"Username already exists")
         }
        if(!authController.familyMemberRepository.existsByUid(registerData.uid)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "UID does not exist")
        }
        val encodedPassword=authController.encoder.encode(registerData.password)
        authController.familyMemberService.register(registerData.uid,registerData.username,encodedPassword)

        val loginDTO=LoginDTO(registerData.username,registerData.password)
        return login(loginDTO)
    }

    @PostMapping("/login")
    @ApiOperation("Login method for users")
    fun login(@RequestBody loginData: LoginDTO): ResponseEntity<Tokens> {
        val authentication: Authentication = authController.authenticationManager
            .authenticate(UsernamePasswordAuthenticationToken(loginData.username, loginData.password))


        SecurityContextHolder.getContext().authentication = authentication




        val user: User = authentication.principal as User
        val jwtCookie: ResponseCookie? = authController.jwtTools.generateJwtCookie(user)
        val tokens=Tokens(jwtCookie.toString(),"")
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,jwtCookie.toString()).body(tokens)
    }




}