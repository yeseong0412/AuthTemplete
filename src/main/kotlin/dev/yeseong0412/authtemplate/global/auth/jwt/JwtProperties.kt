package dev.yeseong0412.authtemplate.global.auth.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class JwtProperties (

    @Value("\${jwt.secret}") val secretKey: String,

    @Value("\${jwt.expire.access}") val accessExpired: Long,

    @Value("\${jwt.expire.refresh}") val refreshExpired: Long

)