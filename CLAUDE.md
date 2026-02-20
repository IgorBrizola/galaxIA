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

galaxIA is a Spring Boot 3.5 web application written in Kotlin, targeting Java 21. It serves as a backend that integrates with the Notion API to extract and aggregate project management data (epics, stories, blocks).

**Tech Stack:**
- Kotlin 1.9.25 with Spring plugin (auto-opens Spring classes)
- Spring Boot Web (REST API)
- Spring Cloud OpenFeign for declarative HTTP clients
- Jackson Kotlin module for JSON serialization
- Log4j2 (default Spring logging excluded)
- SpringDoc OpenAPI (Swagger UI) for API documentation
- JUnit 5 for testing

**Kotlin Configuration:**
- Uses `-Xjsr305=strict` for null-safety annotations from Spring
- Spring plugin enabled for automatic class opening

## Architecture

**Layered structure:** Controller -> Service -> Feign Client -> Notion API

- `controllers/` — REST endpoints under `/galaxIA/notion/` (context-path is `/galaxIA`, port `8082`)
- `services/` — Business logic; `NotionService` orchestrates pagination and synced block resolution
- `integrations/clients/` — Feign client interfaces declaring Notion API calls
- `integrations/dto/` — Raw Notion API response DTOs (mirror Notion's JSON structure)
- `dto/` — Cleaned domain DTOs used in API responses (converted from raw Notion DTOs)
- `configuration/` — Feign interceptor that injects `Authorization` and `Notion-Version` headers

**Key data flow for the main endpoint (`GET /notion/epic/{id}/general/info`):**
1. Fetches the epic page properties via Notion Pages API → converts to `GeneralPageInfoNotion`
2. Fetches block children of the epic (with cursor-based pagination) → converts to `ResultBlockItem` list
3. Resolves synced blocks: if a block references a synced source, fetches that source's children recursively
4. Fetches block children for each related story page
5. Returns aggregated `GeneralInfo` combining epic page info, epic blocks, and story blocks

**Environment variables required:**
- `NOTION_KEY` — Notion integration API token

**API docs available at:** `http://localhost:8082/galaxIA/swagger-ui.html`
