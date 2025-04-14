package com.thomas.common.response

/**
 * @author yanzou
 * @date   2025/4/13
 * @version V1.0.0
 * @description
 **/
data class ErrorResponse(
    var code: Int = 200,
    var message: String? = "success",
    var details: MutableList<String>? = null,
    var url: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)

