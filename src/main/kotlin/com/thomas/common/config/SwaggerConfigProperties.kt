package com.thomas.common.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@ConfigurationProperties(prefix = "swagger")
data class SwaggerConfigProperties(
    var title: String = "default title",
    var description: String = "default description",
    var version: String = "1.0.0"
)