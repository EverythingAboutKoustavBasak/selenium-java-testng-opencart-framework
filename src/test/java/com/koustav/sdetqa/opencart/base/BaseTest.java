//package com.koustav.sdetqa.opencart.base;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import com.koustav.sdetqa.opencart.factory.DriverFactory;
//import com.koustav.sdetqa.opencart.pages.HomePage;
//
//public class BaseTest {
//
//	
//	 protected WebDriver driver;
//	 protected HomePage homePage;
//
//
////	    @BeforeMethod
////	    public void setUp() {
////	        driver = DriverFactory.initDriver("chrome");
////	        driver.get("https://tutorialsninja.com/demo/index.php?");
////	        
////	        // ✅ HomePage initialized here
////	        homePage = new HomePage(driver);
////	    }
//	    
//	    
//	    @Parameters("browser")
//	    @BeforeMethod(alwaysRun = true)
//	    public void setUp(@Optional("chrome") String browser) {
//	    	
//	    	
//
//	        driver = DriverFactory.initDriver(browser);
//	        driver.get("https://tutorialsninja.com/demo/index.php?");
//
//	        homePage = new HomePage(driver);
//	    }
//
//	    @AfterMethod(alwaysRun = true)
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
//}


package com.koustav.sdetqa.opencart.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.koustav.sdetqa.opencart.config.ConfigReader;
import com.koustav.sdetqa.opencart.factory.DriverFactory;
import com.koustav.sdetqa.opencart.pages.HomePage;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("") String xmlBrowser, Method method) { //Method is used for populating the test name in log fine

        String browserName = resolveBrowser(xmlBrowser);

        logger.info("===== TEST STARTED =====");
        logger.info("Thread ID: {}", Thread.currentThread().getId());
        logger.info("Application Name: {}", ConfigReader.get("app.name"));
        logger.info("Environment: {}", System.getProperty("env", "qa"));
        logger.info("Browser selected: {}", browserName);
        logger.info("App URL: {}", ConfigReader.get("app.url"));
        logger.info("Test Name: {}", method.getName());

        // 1️⃣ Create driver (DriverFactory should handle headless internally)
        driver = DriverFactory.initDriver(browserName);

        // 2️⃣ Maximize browser
        driver.manage().window().maximize();

//        // 3️⃣ Implicit wait from config
//        driver.manage().timeouts().implicitlyWait(
//                Duration.ofSeconds(ConfigReader.getInt("explicit.wait"))
//        );

        // 4️⃣ Launch application URL
        driver.get(ConfigReader.get("app.url"));

        // 5️⃣ Initialize page object
        homePage = new HomePage(driver);
    }

    private String resolveBrowser(String xmlBrowser) {

        // 1️⃣ Highest priority → System property (CI/CD)
        String sysBrowser = System.getProperty("browser.name");

        if (sysBrowser != null && !sysBrowser.isBlank()) {
            return sysBrowser;
        }

        // 2️⃣ Second → TestNG XML
        if (xmlBrowser != null && !xmlBrowser.isBlank()) {
            return xmlBrowser;
        }

        // 3️⃣ Default → config.properties
        return ConfigReader.get("browser.name");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info("Test execution finished. Closing browser.");

        if (driver != null) {
            driver.quit();
        }
    }
}


































