package com.thomas.common.response

import java.sql.Timestamp

/**
 * @author yanzou
 * @date   2025/4/13
 * @version V1.0.0
 * @description
 **/
data class ApiResponse<T>(
    var code: Int = 200,
    var message: String = "success",
    var data: T? = null,
    val timestamp: Long = System.currentTimeMillis()
){
    init {
        require(code > 0 ){"id must be positive"}
    }
}
