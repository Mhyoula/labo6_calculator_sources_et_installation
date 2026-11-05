# Lab 6 – REST Calculator

## Description

This project is a REST API calculator developed using Kotlin and Spring Boot as part of the SEG3502 laboratory.

The application provides four basic arithmetic operations through HTTP GET endpoints.

## Technologies Used

- Kotlin
- Spring Boot 4.1.2
- Java 17
- Gradle
- Springdoc OpenAPI / Swagger UI

## Available Operations

| Operation | HTTP Method | Endpoint |
|---|---|---|
| Addition | GET | `/calculator/add/{nombre1}/{nombre2}` |
| Subtraction | GET | `/calculator/subtract/{nombre1}/{nombre2}` |
| Multiplication | GET | `/calculator/multiply/{nombre1}/{nombre2}` |
| Division | GET | `/calculator/divide/{nombre1}/{nombre2}` |

## Installation and Execution

### Prerequisites

- Java JDK 17
- Git
- Visual Studio Code (recommended)

### Run the application

1. Clone the repository.
2. Open the project folder in Visual Studio Code.
3. Open a terminal in the folder containing `gradlew.bat`.
4. Run the following command:

```powershell
.\gradlew.bat bootRun
```

The application will start at:

`http://localhost:8080`

## API Documentation

Swagger UI documentation is available at:

`http://localhost:8080/swagger-ui.html`

The OpenAPI specification is available at:

`http://localhost:8080/v3/api-docs`

## Course

SEG3502 – Software Architecture and Design

**Laboratory 6 – REST Calculator**
