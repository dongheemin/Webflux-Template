# Webflux-Template

A **Kotlin + Spring WebFlux** based reactive API project template.  
This repository provides a clean and minimal starting point for building reactive services or microservices using Spring WebFlux.

## Highlights

- Kotlin-based project
- Spring Boot + WebFlux (Reactive Stack) + QueryDSL
- Multi-module ready structure
- Minimal, template-oriented setup

## Project Structure

├── `api`/ # WebFlux application module  
├── `gradle/wrapper/` # Gradle Wrapper  
├── `build.gradle.kts` # Root Gradle configuration  
├── `settings.gradle.kts` # Multi-module settings  
└── `gradle.properties` # Shared Gradle properties


> The `api` module is the main application entry point.  
> Additional modules such as `domain`, `core`, or `client` can be added as the project grows.

## Requirements

- JDK: compatible Java version defined by the project
- Gradle: use the included Gradle Wrapper (`./gradlew`)

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/dongheemin/Webflux-Template.git
cd Webflux-Template
```
### 2. Build the project
```./gradlew clean build```
### 3. Run the application (api module)
```./gradlew :api:bootRun```
Or run the packaged JAR:
```
./gradlew :api:bootJar
java -jar api/build/libs/*.jar
```
- Task names and artifacts may vary depending on the Gradle configuration of the api module.

## Configuration
- This project follows standard Spring Boot configuration conventions.

> application.yml  
> application-{profile}.yml

## Example:

```
spring:
  profiles:
    active: local

server:
  port: 8080
```
For sensitive values (e.g., database credentials), environment variables are recommended.

## Recommended Extensions
For production-grade services, consider adding:
- Spring Boot Actuator (health checks, metrics)
- springdoc-openapi (Swagger / OpenAPI documentation)
- Validation (jakarta.validation)
- R2DBC (PostgreSQL / MySQL) or Reactive MongoDB
- Global error handling with @RestControllerAdvice
- Structured logging (JSON logs, traceId propagation)

## Development Conventions
- Avoid blocking calls (use Schedulers.boundedElastic when unavoidable)
- Keep API response formats consistent
- Propagate trace/context using Reactor Context
- Centralize exception handling

## Contributing
- Issues and pull requests are welcome
- Manage shared dependencies in the root `build.gradle.kts`
- Register new modules in `settings.gradle.kts`