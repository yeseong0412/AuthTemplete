package dev.yeseong0412.authtemplate.global.common.annotation

import org.springframework.security.core.annotation.AuthenticationPrincipal

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? -1L : #this.id")
// if this == anonymousUser return -1 else return userId
annotation class GetAuthenticatedId
