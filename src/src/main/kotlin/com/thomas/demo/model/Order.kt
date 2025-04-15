package com.thomas.demo.model

import java.time.LocalDateTime

/**
 * @author yanzou
 * @date   2025/4/11
 * @version V1.0.0
 * @description
 **/
data class Order(
    var id: Long,
    var createTime: LocalDateTime
)
