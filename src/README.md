# Playwright Framework Template

This project provides a template for building robust Playwright-based automated tests in Java.

## Structure

- **src/main/java**: Contains framework code such as configuration management, browser factory, page objects, and utilities.
- **src/main/resources/config**: Contains environment-specific properties files (`dev.properties`, `qa.properties`, `prod.properties`).
- **src/test/java**: Contains JUnit test cases.
- **src/test/resources/junit-platform.properties**: Configures JUnit 5 for parallel execution.
- **reports**: Directory to store test artifacts like screenshots and logs.

## Setup

1. Clone the repository.
2. Update the configuration files in `src/main/resources/config` as needed.
3. Use Maven to build the project:
   ```bash
   mvn clean install
