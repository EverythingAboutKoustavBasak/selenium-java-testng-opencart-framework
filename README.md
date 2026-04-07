\# Selenium Java TestNG Automation Framework (OpenCart)



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

&#x20;  base/        → Base classes

&#x20;  config/      → ConfigReader

&#x20;  factory/     → DriverFactory

&#x20;  pages/       → Page Object classes

&#x20;  utils/       → Utility classes



src/main/resources/

&#x20;  config/      → Properties files (qa, dev, etc.)

&#x20;  log4j2.xml   → Logging configuration



src/test/java/

&#x20;  base/        → BaseTest

&#x20;  tests/       → Test classes



testng-suites/

&#x20;  testng-smoke.xml

&#x20;  testng-smoke-parallel-crossbrowser.xml

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



