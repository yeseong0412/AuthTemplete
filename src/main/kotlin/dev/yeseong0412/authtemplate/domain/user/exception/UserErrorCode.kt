package dev.yeseong0412.authtemplate.domain.user.exception

import dev.yeseong0412.authtemplate.global.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class UserErrorCode (
    override val status: HttpStatus,
    override val state: String,
    override val message: String,
) : CustomErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "유저를 찾을 수 없습니다"),
    USER_ALREADY_EXIST(HttpStatus.CONFLICT, "CONFLICT", "유저가(이메일이) 이미 존재합니다"),
    USER_NOT_MATCH(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "이메일또는 비밀번호가 잘못되었습니다.")

}