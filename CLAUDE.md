# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build the project
./mvnw clean package

# Run the application
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=GalaxIaApplicationTests

# Run a single test method
./mvnw test -Dtest=GalaxIaApplicationTests#contextLoads
```

## Project Overview

galaxIA is a Spring Boot 3.5 web application written in Kotlin, targeting Java 21.

**Tech Stack:**
- Kotlin 1.9.25 with Spring plugin (auto-opens Spring classes)
- Spring Boot Web (REST API)
- Jackson Kotlin module for JSON serialization
- JUnit 5 for testing

**Package Structure:**
- Base package: `com.rizasec.galaxIA`
- Main class: `GalaxIaApplication.kt`

**Kotlin Configuration:**
- Uses `-Xjsr305=strict` for null-safety annotations from Spring
- Spring plugin enabled for automatic class opening
