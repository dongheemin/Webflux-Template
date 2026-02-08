plugins {
    kotlin("jvm") version "1.7.20" apply false
    kotlin("kapt") version "1.7.20" apply false
    kotlin("plugin.spring") version "1.7.20" apply false

    id("org.springframework.boot") version "2.7.4" apply false
    id("io.spring.dependency-management") version "1.0.14.RELEASE" apply false
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }
    group = "net.donggul"
    version = "1.0"
}
