package com.thomas.common.response

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * @author yanzou
 * @date   2025/4/13
 * @version V1.0.0
 * @description
 **/
data class ErrorResponse(
    var code: Int = 200,
    var message: String? = "success",
    var details: Map<String, String>? = null,
    var url: String? = null,
    val timestamp: String = LocalDateTime.now(ZoneId.of("Asia/Tokyo")).format(DateTimeFormatter.ISO_DATE_TIME)
)

