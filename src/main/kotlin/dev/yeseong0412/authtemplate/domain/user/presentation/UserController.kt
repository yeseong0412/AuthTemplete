package dev.yeseong0412.authtemplate.domain.user.presentation

import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.LoginRequest
import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.RefreshRequest
import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.RegisterUserRequest
import dev.yeseong0412.authtemplate.domain.user.service.UserService
import dev.yeseong0412.authtemplate.global.auth.jwt.JwtInfo
import dev.yeseong0412.authtemplate.global.common.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun registerUser(@RequestBody registerUserRequest: RegisterUserRequest): BaseResponse<Unit> {
        return userService.registerUser(registerUserRequest)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: LoginRequest): BaseResponse<JwtInfo> {
        return userService.loginUser(loginRequest)
    }

    @PostMapping("/refresh")
    fun refreshUser(@RequestBody refreshRequest: RefreshRequest): BaseResponse<String> {
        return userService.refreshToken(refreshRequest)
    }
}