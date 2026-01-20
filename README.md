# Cucumber Selenium Test Automation Framework

A comprehensive BDD (Behavior-Driven Development) test automation framework built with Cucumber, Selenium WebDriver, and TestNG for end-to-end testing of web applications.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Framework Components](#framework-components)
- [Contributing](#contributing)

## 🎯 Overview

This project implements a Page Object Model (POM) based test automation framework using Cucumber BDD for testing e-commerce functionality. The framework supports parallel test execution, comprehensive reporting, and follows industry best practices for maintainable and scalable test automation.

## ✨ Features

- **BDD with Cucumber**: Write tests in Gherkin syntax for better collaboration
- **Page Object Model**: Maintainable and reusable page objects
- **Parallel Execution**: Run tests in parallel using TestNG
- **Dependency Injection**: PicoContainer for managing test context
- **Automatic Driver Management**: WebDriverManager handles browser drivers
- **Rich Reporting**: ExtentReports integration for detailed test reports
- **Failed Scenario Rerun**: Automatically rerun failed test scenarios
- **Tag-based Execution**: Run specific test suites using Cucumber tags
- **Cross-browser Support**: Configurable browser selection

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | - | Programming Language |
| Selenium WebDriver | 4.38.0 | Browser Automation |
| Cucumber | 7.32.0 | BDD Framework |
| TestNG | - | Test Execution Framework |
| Maven | - | Build & Dependency Management |
| WebDriverManager | 5.6.3 | Automatic Driver Management |
| ExtentReports | 5.1.1 | Test Reporting |
| PicoContainer | 7.32.0 | Dependency Injection |

## 📁 Project Structure

```
Cucumber_project_1/
├── src/
│   ├── main/
│   │   └── java/
│   │       
│   │           
│   └── test/
│       └── java/
│           ├── features/                    # Feature files
│           │   ├── checkOut.feature
│           │   └── searchProduct.feature
│           ├── Hooks/                       # Test hooks
│           │   └── Hooks.java
│           ├── io/cucumberr/Cucumber_project_1/
│           │   ├── TestRunner.java          # Main test runner
│           │   └── Failed_scenarios.java    # Failed scenario runner
│           ├── pageObjects/                 # Page Object classes
│           │   ├── CheckOutPageObj.java
│           │   ├── LandingPageObject.java
│           │   ├── OfferPageObject.java
│           │   └── PageObjectManager.java
│           ├── setDefinations/              # Step definitions
│           │   ├── ChcekOutPagePageStepDef.java
│           │   ├── LandingPageStepDef.java
│           │   └── OfferPageStepDef.java
│           └── utils/                       # Utility classes
│               ├── ConfigFileReader.java
│               ├── GenericUtils.java
│               ├── TestBase.java
│               └── TestContextSetup.java
├── target/                                  # Build output
│   ├── cucumber-reports.html
│   └── rerun.txt
├── test-output/                            # TestNG reports
├── pom.xml                                 # Maven configuration
└── README.md
```

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

- **Java JDK** (version 8 or higher)
- **Maven** (version 3.6 or higher)
- **IDE** (Eclipse, IntelliJ IDEA, or VS Code)
- **Git** (for version control)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd Automation-BDD-Engine
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify installation**
   ```bash
   mvn test
   ```

## ⚙️ Configuration

### Browser Configuration

Update the browser configuration in your configuration file or test base:
- Default browser: Chrome
- Supported browsers: Chrome (extensible for Firefox, Edge, etc.)

### Test Data

Feature files are located in `src/test/java/features/` and use Scenario Outline with Examples for data-driven testing.

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Tags
```bash
mvn test -Dcucumber.filter.tags="@checkout"
mvn test -Dcucumber.filter.tags="@search"
```

### Run with Parallel Execution
The framework is configured for parallel execution by default in `TestRunner.java`.

### Rerun Failed Scenarios
```bash
mvn test -Dcucumber.features="@target/rerun.txt"
```

Or use the `Failed_scenarios.java` runner class.

## 📊 Test Reports

The framework generates multiple types of reports:

### 1. Cucumber HTML Report
- **Location**: `target/cucumber-reports.html`
- **Description**: Standard Cucumber HTML report

### 2. ExtentReports
- **Location**: `test-output/`
- **Description**: Rich, interactive HTML reports with screenshots and detailed test execution information

### 3. TestNG Reports
- **Location**: `test-output/index.html`
- **Description**: TestNG native HTML reports

### 4. Rerun File
- **Location**: `target/rerun.txt`
- **Description**: Contains failed scenarios for rerun

## 🏗️ Framework Components

### Page Objects
- **LandingPageObject**: Home page interactions
- **OfferPageObject**: Offer page interactions
- **CheckOutPageObj**: Checkout page interactions
- **PageObjectManager**: Centralized page object management

### Step Definitions
- **LandingPageStepDef**: Landing page step implementations
- **OfferPageStepDef**: Offer page step implementations
- **ChcekOutPagePageStepDef**: Checkout page step implementations

### Utilities
- **TestBase**: WebDriver initialization and management
- **TestContextSetup**: Shared context across step definitions
- **GenericUtils**: Common utility methods
- **ConfigFileReader**: Configuration file handling

### Hooks
- **Hooks.java**: Before and After scenario hooks for setup and teardown

## 🧩 Test Scenarios

### Search Product Feature (`@search`)
- Search for products on home page
- Verify product availability on offer page
- Validate product name consistency across pages

### Checkout Feature (`@checkout`)
- Search and add products to cart
- Proceed to checkout
- Validate cart items
- Apply promo codes and place orders

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Best Practices

- Keep feature files simple and readable
- Follow Page Object Model pattern
- Use meaningful variable and method names
- Add proper waits (avoid Thread.sleep)
- Maintain test data separately
- Write independent test scenarios
- Use tags for test organization
- Keep step definitions focused and reusable

## 🐛 Troubleshooting

### Common Issues

1. **Driver not found**: WebDriverManager should handle this automatically. Ensure internet connectivity.
2. **Element not found**: Check for proper waits and element locators
3. **Parallel execution issues**: Ensure thread-safe WebDriver management

## 📧 Contact

For questions or support, please open an issue in the repository.

---

**Happy Testing! 🚀**

