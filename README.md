# DeelTask

This project uses Playwright for end-to-end UI automation testing of the Deel Salaries website.
It is built using the Page Object Model (POM) design pattern, integrated with TestNG for test execution and Maven for dependency management.

## Technologies Used

- **Playwright for Java:** A modern browser automation framework.
- **TestNG:** A testing framework for managing and executing test cases.
- **Java 17:** The programming language used for scripting.
- **Maven:** Build automation tool for dependency and lifecycle management.

## Features

- **Playwright for Java:** Ensures reliable and scalable end-to-end UI testing.
- **Page Object Model (POM):** Modular design for reusable and maintainable test code.
- **Cucumber:** Framework that lets teams write test scenarios in plain English (Gherkin syntax).

## Prerequisites

Ensure you have the following installed:

- **Java Development Kit (JDK)** 17 or higher.

```
 java -version
```

- **Maven** (for dependency management).

```
 mvn -v
```

## Setup Instructions

Follow these steps to set up and run the project:

### 1. Clone the Repository

```bash
git clone https://github.com/hala-samir/
cd DeelTask
```

### 2. Run Tests Locally

Build the project and execute tests:

```
mvn clean test
```

## Project Structure

```
Playwright-DeelTask/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── factories/        # Classes for creating and managing browser/page instances
│   │       ├── pages/            # Page Object Model classes representing UI pages
│   │       └── utilities/        # Helper classes like PropertiesHandler.
│   ├── test/
│   │   └── java/
│   │       ├── runners/          # TestNG or Cucumber test runner classes
│   │       └── stepDefinitions/  # Step definition classes for Cucumber scenarios
│   │   └── resources/
│   │       ├── config/           # Configuration files (e.g., testConfig.properties)
│   │       ├── features/         # Cucumber feature files
│   │       └── testSuites/       # TestNG XML files or grouped test suites
├── target/                        # Build output folder
│   └── surefire-reports/          # Test execution reports
├── pom.xml                         # Maven project file with dependencies
├── README.md                       # Project documentation
└── .gitignore                      # Git ignore rules
```

## Notes

### Thread.sleep() Usage:

In some steps, Thread.sleep() is intentionally used due to unavoidable UI delays in rendering dropdown options. Normally, explicit waits (waitForSelector) are preferred, but this delay cannot be avoided in this demo application.

## Parallel Execution:

Not required for this task; tests run sequentially.

## Reports

After test execution, a Cucumber HTML report will be available at:

```
target/cucumber-report.html
```
