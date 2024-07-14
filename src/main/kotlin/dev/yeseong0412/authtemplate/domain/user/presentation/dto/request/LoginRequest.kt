package dev.yeseong0412.authtemplate.domain.user.presentation.dto.request

data class LoginRequest(
    val email: String = "",
    val password: String = ""
)
