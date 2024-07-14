package dev.yeseong0412.authtemplate.domain.user.presentation.dto.request

data class RegisterUserRequest(
    val email: String = "",
    val name: String = "",
    val password: String = ""
)
