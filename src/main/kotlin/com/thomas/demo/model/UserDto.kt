package com.thomas.demo.model

import jakarta.validation.constraints.Max

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
data class UserDto(
    @Max(value = 20L)
    var id: Long = 0L,
)