package com.thomas.common.db

import com.thomas.common.config.SwaggerConfigProperties
import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@Configuration
@EnableJpaRepositories(
    basePackages = ["com.thomas"],
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManagerRef"
)
@EnableConfigurationProperties(DbConfigProperties::class)
class JpaCommonConfig(private var configProperties: DbConfigProperties) {
    @Bean
    @Primary
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName(configProperties.driverClassName)
            .url(configProperties.url)
            .username(configProperties.username)
            .password(configProperties.password)
            .build()
    }

    @Bean
    @Primary
    fun entityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder.dataSource(dataSource())
            .packages(configProperties.packages)
            .persistenceUnit("default")
            .build()
    }

    @Bean
    @Primary
    fun transactionManagerRef(emf: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(emf)
    }
}