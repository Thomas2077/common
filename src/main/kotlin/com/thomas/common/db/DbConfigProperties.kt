package com.thomas.common.db

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@ConfigurationProperties(prefix = "spring.datasource")
data class DbConfigProperties (
    var url: String = "",
    var driverClassName: String = "",
    var username : String = "",
    var password: String = "",
    var packages: String = "com.thomas.entity"
)
