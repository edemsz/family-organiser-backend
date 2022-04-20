package bme.familyorganiserbackend.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseCookie
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*


@Component
open class JWTTools {
    @Value("app.jwtSecret")
    private lateinit var jwtSecret: String

    @Value("\${app.jwtExpirationMs}")
    private var jwtExpirationMs :Int=0


    @Value("app.jwtCookieName")
    private lateinit var jwtCookie: String



    fun getDecodedJWT(authorizationHeader: String): DecodedJWT {
        val token = authorizationHeader
        val algorithm: Algorithm = Algorithm.HMAC256(jwtSecret)
        val verifier: JWTVerifier = JWT.require(algorithm).build()
        return verifier.verify(token)
    }

    fun getUsernameFromJwt(authorizationHeader: String): String? {
        println(authorizationHeader)
        val username= getDecodedJWT(authorizationHeader).subject
        println(username)
        return username
    }

    fun createAccessToken(username: String?, roles: List<String?>?, requestUrl: String?): String? {
        val algorithm: Algorithm = Algorithm.HMAC256(jwtSecret)
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(Date(System.currentTimeMillis() + jwtExpirationMs))
                .withIssuer(requestUrl)
                .withClaim("roles", roles)
                .sign(algorithm)
    }



}