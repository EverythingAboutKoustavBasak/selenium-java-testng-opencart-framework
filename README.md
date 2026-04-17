\# Selenium Java TestNG Automation Framework (OpenCart - "https://tutorialsninja.com/demo/index.php?")



\## 📌 Overview



This project is a \*\*Hybrid Selenium Automation Framework\*\* built using \*\*Java, TestNG, and Maven\*\* to automate the OpenCart application.



The framework follows industry best practices like \*\*Page Object Model (POM)\*\*, \*\*Config-driven execution\*\*, and \*\*multi-environment support\*\*.



\---



\## 🚀 Features



\* ✅ Page Object Model (POM) design pattern

\* ✅ Config-driven framework (no hardcoding)

\* ✅ Multi-environment support (QA, DEV, STAGE, PROD)

\* ✅ Cross-browser testing (Chrome, Firefox, Edge)

\* ✅ Headless execution support

\* ✅ Logging using Log4j2

\* ✅ TestNG suite management

\* ✅ Clean and scalable architecture



\---



\## 🏗️ Project Structure



```

src/main/java/

  base/        → Base classes

  config/      → ConfigReader

  factory/     → DriverFactory

  pages/       → Page Object classes

  utils/       → Utility classes



src/main/resources/

  config/      → Properties files (qa, dev, etc.)

  log4j2.xml   → Logging configuration



src/test/java/

  base/        → BaseTest

  tests/       → Test classes



testng-suites/

  testng-smoke.xml

  testng-smoke-parallel-crossbrowser.xml

```



\---



\## ⚙️ Configuration



\### 🔹 config.properties



```

browser.name=chrome

browser.headless=false

explicit.wait=10

```



\### 🔹 qa.properties



```

app.url=https://tutorialsninja.com/demo

app.username=qa\_user@mail.com

app.password=Test123

```



\---



\## ▶️ How to Run Tests



\### 🟢 Run default (QA)



```

mvn test

```



\### 🔵 Run with different environment



```

mvn test -Denv=dev

mvn test -Denv=stage

```



\### 🟣 Run with different browser



```

mvn test -Dbrowser.name=firefox

mvn test -Dbrowser.name=edge

```



\### ⚫ Run in headless mode



```

mvn test -Dbrowser.headless=true

```



\---



\## 🧪 Test Execution



Tests are managed using TestNG XML files:



```

testng-suites/testng-smoke.xml

testng-suites/testng-smoke-parallel-crossbrowser.xml

```



\---



\## 📊 Logging



Logging is implemented using \*\*Log4j2\*\*.



Logs are generated during execution for better debugging and traceability.



\---



\## 💼 Tech Stack



\* Java

\* Selenium WebDriver

\* TestNG

\* Maven

\* Log4j2



\---



\## 👨‍💻 Author



\*\*Koustav Basak\*\*



\---



\## ⭐ Future Enhancements



\* Parallel execution using ThreadLocal

\* CI/CD integration (Jenkins/GitHub Actions)

\* Extent Reports integration

\* API + UI combined framework

**- And we try to follow this structure - **
ui-automation-framework/
│
├── src/
│   ├── main/
│   │   ├── java/com/yourcompany/ui/
│   │   │
│   │   │   ├── base/
│   │   │   │     └── BasePage.java
│   │   │
│   │   │   ├── driver/                    ⭐ Thread-safe driver
│   │   │   │     ├── DriverFactory.java
│   │   │   │     └── DriverManager.java   (ThreadLocal)
│   │   │
│   │   │   ├── pages/                     ⭐ POM
│   │   │   │     ├── LoginPage.java
│   │   │   │     ├── HomePage.java
│   │   │   │     └── RegisterPage.java
│   │   │
│   │   │   ├── services/                  ⭐ Business layer
│   │   │   │     ├── LoginService.java
│   │   │   │     └── RegistrationService.java
│   │   │
│   │   │   ├── wrappers/                  ⭐ Stability layer
│   │   │   │     ├── ElementActions.java
│   │   │   │     └── WaitUtils.java
│   │   │
│   │   │   ├── utils/
│   │   │   │     ├── ConfigReader.java
│   │   │   │     ├── FakerUtils.java
│   │   │   │     └── ScreenshotUtils.java
│   │   │
│   │   │   ├── constants/
│   │   │   │     └── FrameworkConstants.java
│   │   │
│   │   │   ├── listeners/
│   │   │   │     └── TestListener.java
│   │   │
│   │   │   ├── reports/
│   │   │   │     └── ExtentManager.java
│   │   │
│   │   │   └── exceptions/
│   │   │         └── FrameworkException.java
│   │
│   │   └── resources/
│   │         ├── config/
│   │         │     ├── config.properties
│   │         │     ├── qa.properties
│   │         │     └── prod.properties
│   │         │
│   │         └── testdata/
│   │               └── testdata.json
│
│   ├── test/
│   │   ├── java/com/yourcompany/tests/
│   │   │
│   │   │   ├── base/
│   │   │   │     └── BaseTest.java
│   │   │   │
│   │   │   ├── ui/
│   │   │   │     ├── LoginTest.java
│   │   │   │     └── RegistrationTest.java
│   │   │
│   │   └── resources/
│   │         └── testng/
│   │               ├── testng.xml
│   │               └── regression.xml
│
├── logs/
├── reports/
├── screenshots/
├── test-output/
│
├── pom.xml
├── Jenkinsfile
└── README.md



