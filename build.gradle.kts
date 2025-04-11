plugins {
    kotlin("jvm") version "1.9.10" apply false
    id("org.springframework.boot") version "3.1.4" apply false
    id("io.spring.dependency-management") version "1.1.3" apply false
    `java-library`                      // ✅ 关键！
    `maven-publish`                    // ✅ 用于发布
}

allprojects {
    group = "com.thomas"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
    }
}
dependencies {
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.12")
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
