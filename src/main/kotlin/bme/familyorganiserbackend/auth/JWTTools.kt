package bme.familyorganiserbackend.auth

import bme.familyorganiserbackend.familymember.FamilyMember
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Component
import java.util.*


@Component
open class JWTTools {
    @Value("app.jwtSecret")

    private lateinit var jwtSecret: String
    @Value("app.jwtExpirationMs")
    private val jwtExpirationMs = 0

    @Value("app.jwtCookieName")
    private lateinit var jwtCookie: String

    fun generateJwtCookie(userPrincipal: FamilyMember): ResponseCookie? {
        val jwt: String = generateTokenFromUsername(userPrincipal.username)
        return ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge((24 * 60 * 60).toLong()).httpOnly(true).build()
    }

    fun getUserNameFromJwtToken(token: String?): String? {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject
    }

    fun generateTokenFromUsername(username: String?): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
    }


}