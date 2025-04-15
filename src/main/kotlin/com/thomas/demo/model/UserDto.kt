package com.thomas.demo.model

import jakarta.validation.constraints.NotBlank

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
data class UserDto(
    var id: Long? = null,

    @field:NotBlank(message = "name should not be null")
    var name: String = "123",
)