Nexora Auth Service
Overview

Nexora Auth Service is a cloud-native authentication and authorization microservice built using Spring Boot 3 and Java 17.

It provides secure identity management, JWT-based authentication, role-based access control (RBAC), and integrates with other services within the Nexora Commerce Platform.

This service is designed following clean architecture principles and production-grade security standards.

🚀 Tech Stack

Java 17

Spring Boot 3

Spring Security 6

Spring Data JPA

PostgreSQL

JWT (Access & Refresh Tokens)

Docker

Maven

MapStruct

Lombok

🏗 Architecture

The service follows:

Hexagonal Architecture (Ports & Adapters)

Domain-Driven Design principles

Stateless authentication

Token-based security

High-level layers:

Controller → Application → Domain → Infrastructure

Controller Layer: REST endpoints

Application Layer: Use cases / orchestration

Domain Layer: Business logic (pure Java)

Infrastructure Layer: Database, JWT provider, external integrations

🔐 Security Model

Stateless authentication

Access token (short-lived)

Refresh token (long-lived)

BCrypt password hashing

Role-Based Access Control (RBAC)

Method-level security

📦 Features

User registration

Login

Token generation

Token refresh

Role assignment

Secure endpoint protection

Custom authentication filter

Global exception handling

🧠 Engineering Decisions

No shared database with other services

Service-to-service communication secured via JWT

Stateless design for horizontal scalability

Designed to support OAuth2 in future

🐳 Running Locally
docker-compose up -d

Or:

./mvnw spring-boot:run
📊 Future Improvements

OAuth2 / OpenID Connect support

Keycloak integration

Multi-tenant support

Distributed tracing integration

Rate limiting

Account locking mechanism

📜 License

MIT License
