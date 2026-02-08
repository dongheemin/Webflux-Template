plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")
}
dependencies {
    implementation(libs.kotlin.jackson)
    implementation(libs.webflux)
    implementation(libs.r2dbc)
    implementation(libs.querydsl.core)
    implementation(libs.querydsl.r2dbc)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
tasks.test {
    useJUnitPlatform()
}