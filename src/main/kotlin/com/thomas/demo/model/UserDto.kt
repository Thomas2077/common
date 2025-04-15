package com.thomas.demo.model

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
data class UserDto(
    @Max(value = 20L)
    var id: Long? = null,

    @NotBlank(message = "name should not be null")
    var name: String = "123",
)