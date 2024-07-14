package dev.yeseong0412.authtemplate

import dev.yeseong0412.authtemplate.global.common.annotation.GetAuthenticatedId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @PostMapping("/")
    fun test(
        @GetAuthenticatedId userId: Long
    ){
        println("======================")
        println("userId = $userId")
        println("======================")
    }
}