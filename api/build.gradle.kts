plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")
}

dependencies {
    implementation(project(":search"))
    implementation(libs.bundles.spring.client)
    implementation(libs.bundles.kotlin.webflux)
    implementation(libs.bundles.r2dbc.postgres)
    implementation(libs.bundles.r2dbc.querydsl)
    implementation(libs.spring.kafka)
    kapt(libs.bundles.r2dbc.querydsl)
    testImplementation(libs.bundles.test)
}

configurations { all { exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging") } }
dependencyManagement { imports { mavenBom(libs.spring.cloud.bom.get().toString()) } }
kapt {
    keepJavacAnnotationProcessors = true
}
tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    processResources {
        if(project.gradle.startParameter.taskNames.contains("build")) exclude("application.yml")
    }
    bootJar {
        archiveFileName.set("api.jar")
    }
    jar {
        enabled = false
    }
    test {
        useJUnitPlatform()
    }
}
