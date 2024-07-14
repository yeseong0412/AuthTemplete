package dev.yeseong0412.authtemplate.domain.user.domain.mapper

import dev.yeseong0412.authtemplate.domain.user.domain.entity.UserEntity
import dev.yeseong0412.authtemplate.domain.user.domain.model.User
import dev.yeseong0412.authtemplate.global.common.Mapper


class UserMapper: Mapper<User, UserEntity> {
    override fun toDomain(entity: UserEntity): User {
        TODO("Not yet implemented")
    }

    override fun toEntity(domain: User): UserEntity {
        TODO("Not yet implemented")
    }
}