package com.thomas.common.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@Configuration
@EnableConfigurationProperties(SwaggerConfigProperties::class)
class SwaggerConfig(private var props: SwaggerConfigProperties) {

    @Bean
    fun customerOpenAPI() : OpenAPI{
        return OpenAPI().info(
            Info()
                .version(props.version)
                .description(props.description)
                .title(props.title)
        );
    }
}