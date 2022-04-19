package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.auth.*
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/family-member")
open class FamilyMemberController:
    AbstractController<FamilyMember, CreateFamilyMember, FamilyMemberGet>()
 {
     @Autowired
     lateinit var familyMemberService: FamilyMemberService
     @Autowired
     lateinit var authController: AuthController
     @Autowired
     lateinit var jwtTools: JWTTools


     @GetMapping("/me")
     @ApiOperation("Gets the family member of the current user")
     fun getMe(@RequestHeader headers: HttpHeaders){
         val authHeader:String= headers["Authorization"].toString()
         println(jwtTools.getUserNameFromJwtToken(authHeader))
     }




     @PostMapping("/sign-up")
    @ApiOperation("Sign up method for users")
    fun register(@RequestBody registerData: RegistrationDTO): ResponseEntity<Tokens> {
        familyMemberService.register(registerData)

        val loginDTO=LoginDTO(registerData.username,registerData.password)
        return login(loginDTO)
    }

    @PostMapping("/login")
    @ApiOperation("Login method for users")
    fun login(@RequestBody loginData: LoginDTO): ResponseEntity<Tokens> {
        val tokens=familyMemberService.login(loginData)
        val jwtCookie=tokens.accessToken
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,jwtCookie.toString()).body(tokens)
    }




}