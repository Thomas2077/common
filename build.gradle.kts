plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10" // 了 Spring 注解的类（如 @Configuration, @Service, @Controller 等）变成 open，
    id("io.spring.dependency-management") version "1.1.3"  // ✅ 启用
    `java-library`
    `maven-publish`
}

group = "com.thomas"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.12")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2") // ✅ 内存数据库
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.4")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.thomas"
            artifactId = "kotlin-common"
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }
}
