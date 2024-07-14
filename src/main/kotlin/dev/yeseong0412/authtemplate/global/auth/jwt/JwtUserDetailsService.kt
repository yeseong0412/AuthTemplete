package dev.yeseong0412.authtemplate.global.auth.jwt

import dev.yeseong0412.authtemplate.domain.user.domain.UserRepository
import dev.yeseong0412.authtemplate.domain.user.domain.mapper.UserMapper
import dev.yeseong0412.authtemplate.domain.user.exception.UserErrorCode
import dev.yeseong0412.authtemplate.global.exception.CustomException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JwtUserDetailsService (
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserDetailsService {

    @Transactional(readOnly = true)
    override fun loadUserByUsername(email: String): UserDetails {
        return JwtUserDetails (
            user = userMapper.toDomain(
               entity = userRepository.findByEmail(email)?: throw CustomException(UserErrorCode.USER_NOT_FOUND)
            )
        )
    }

}