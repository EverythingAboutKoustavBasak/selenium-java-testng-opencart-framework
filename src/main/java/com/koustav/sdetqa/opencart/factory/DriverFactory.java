//package com.koustav.sdetqa.opencart.factory;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//public class DriverFactory {
//
//    private static final Logger logger =
//            LogManager.getLogger(DriverFactory.class);
//    
//    
//    /*
//     * create the the private constructor to initialization of the object outside of this class.
//     * control object creation using Factory Design Pattern
//     */
//    private DriverFactory() {}; 
//    
//    
//    public static WebDriver initDriver(String browserName) {
//    	
//
//        if (browserName == null || browserName.trim().isEmpty()) {
//            throw new IllegalArgumentException("Browser name cannot be null or empty");
//        }
//
//        WebDriver driver;
//
//        logger.info("Initializing WebDriver... ");
//        logger.info("Browser requested: {}", browserName);
//        
//        String browser = browserName.trim().toLowerCase();
//
//        switch (browser) {
//
//        case "chrome":
//            logger.info("Launching Chrome browser");
//            ChromeOptions chromeOptions = new ChromeOptions();
//            driver = new ChromeDriver(chromeOptions);
//            break;
//
//        case "firefox":
//            logger.info("Launching Firefox browser");
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            driver = new FirefoxDriver(firefoxOptions);
//            break;
//
//        case "edge":
//            logger.info("Launching Edge browser");
//            System.setProperty("webdriver.edge.driver","C:\\drivers\\msedgedriver.exe");
//            EdgeOptions edgeOptions = new EdgeOptions();
//            driver = new EdgeDriver(edgeOptions);
//            break;
//            
//       
//
//        default:
//            logger.error("Unsupported browser: {}", browser);
//            throw new IllegalArgumentException("Unsupported browser: " + browser);
//   
//        
//        }
//
//        logger.info("Maximizing browser window");
//        driver.manage().window().maximize();
//
////        logger.info("Setting implicit wait to 0 seconds");
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//
//        logger.info("WebDriver initialized successfully");
//
//        return driver;
//    }
//}


package com.koustav.sdetqa.opencart.factory;

import com.koustav.sdetqa.opencart.config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {}

    public static WebDriver initDriver(String browserName) {

        if (browserName == null || browserName.isBlank()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty");
        }

        WebDriver driver;
        String browser = browserName.trim().toLowerCase();

        boolean isHeadless = ConfigReader.getBoolean("browser.headless");

        logger.info("Initializing WebDriver...");
        logger.info("Browser requested: {}", browser);
        logger.info("Headless mode: {}", isHeadless);

        switch (browser) {

            case "chrome":
                logger.info("Launching Chrome browser");
                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                logger.info("Launching Firefox browser");
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                logger.info("Launching Edge browser");
                EdgeOptions edgeOptions = new EdgeOptions();

                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }

                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                logger.error("Unsupported browser: {}", browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        logger.info("WebDriver initialized successfully");

        return driver;
    }
}
















