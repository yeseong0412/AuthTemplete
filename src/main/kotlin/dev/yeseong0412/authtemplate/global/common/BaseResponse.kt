package dev.yeseong0412.authtemplate.global.common

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BaseResponse<T> (

    val status: Int = HttpStatus.OK.value(),
    val state: String? = "OK",
    val message: String,
    val data: T? = null

)

