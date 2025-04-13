plugins {
    kotlin("jvm") version "1.9.10"
    id("io.spring.dependency-management") version "1.1.3"  // ✅ 启用
    `java-library`
    `maven-publish`
}

group = "com.th"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.12")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.4")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.th"
            artifactId = "kotlin-common"
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }
}
