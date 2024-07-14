package dev.yeseong0412.authtemplate.global.auth.jwt

import dev.yeseong0412.authtemplate.domain.user.domain.model.User
import dev.yeseong0412.authtemplate.global.auth.jwt.exception.type.JwtErrorType
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.SignatureException
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtils(
    private val jwtProperties: JwtProperties,
    private val userDetailsService: UserDetailsService,
) {

    private val secretKey: SecretKey = SecretKeySpec(
        this.jwtProperties.secretKey.toByteArray(StandardCharsets.UTF_8),
        Jwts.SIG.HS256.key().build().algorithm
    )

    fun getUsername(token: String): String {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).payload.get(
            "email",
            String::class.java
        )
    }

    fun checkTokenInfo(token: String): JwtErrorType {
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
            return JwtErrorType.OK
        } catch (e: ExpiredJwtException) {
            return JwtErrorType.ExpiredJwtException
        } catch (e: SignatureException) {
            return JwtErrorType.SignatureException
        } catch (e: MalformedJwtException) {
            return JwtErrorType.MalformedJwtException
        } catch (e: UnsupportedJwtException) {
            return JwtErrorType.UnsupportedJwtException
        } catch (e: IllegalArgumentException) {
            return JwtErrorType.IllegalArgumentException
        } catch (e: Exception) {
            return JwtErrorType.UNKNOWN_EXCEPTION
        }
    }

    fun getToken(token: String): String {
        return token.removePrefix("Bearer ")
    }

    fun generate(user: User): JwtInfo {
        val accessToken = createToken(
            user = user,
            tokenExpired = jwtProperties.accessExpired
        )
        val refreshToken = createToken(
            user = user,
            tokenExpired = jwtProperties.refreshExpired
        )


        return JwtInfo("Bearer $accessToken", "Bearer $refreshToken")
    }

    fun getAuthentication(token: String): Authentication {
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(getUsername(getToken(token)))
        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    fun refreshToken(user: User): String {

        return "Bearer " + createToken(
            user = user,
            tokenExpired = jwtProperties.accessExpired
        )
    }

    private fun createToken(user: User, tokenExpired: Long): String {
        val now: Long = Date().time
        return Jwts.builder()
            .claim("id", user.id)
            .claim("email", user.email)
            .claim("role", user.role)
            .issuedAt(Date(now))
            .expiration(Date(now + tokenExpired))
            .signWith(secretKey)
            .compact()
    }

}