package dev.yeseong0412.authtemplate.domain.user.service

import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.LoginRequest
import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.RefreshRequest
import dev.yeseong0412.authtemplate.domain.user.presentation.dto.request.RegisterUserRequest
import dev.yeseong0412.authtemplate.global.auth.jwt.JwtInfo
import dev.yeseong0412.authtemplate.global.common.BaseResponse

interface UserService {
    fun registerUser(registerUserRequest: RegisterUserRequest): BaseResponse<Unit>
    fun loginUser(loginRequest: LoginRequest): BaseResponse<JwtInfo>
    fun refreshToken(refreshRequest: RefreshRequest): BaseResponse<String>
}