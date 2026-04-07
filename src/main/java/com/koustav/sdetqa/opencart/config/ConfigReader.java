//package com.koustav.sdetqa.opencart.config;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//public final class ConfigReader {
//
//    private static final Properties configProps = new Properties();
//    private static final Properties envProps = new Properties();
//
//    // static block = loaded once when JVM starts
//    static {
//        loadProperties("config/config.properties", configProps);
//
//        String env = System.getProperty("env", "qa");
//        loadProperties("config/" + env + ".properties", envProps);
//    }
//
//    private ConfigReader() {
//        // prevent object creation
//    }
//
//    private static void loadProperties(String path, Properties props) {
//        try (InputStream is =
//                ConfigReader.class
//                        .getClassLoader()
//                        .getResourceAsStream(path)) {
//
//            if (is == null) {
//                throw new RuntimeException("Property file not found: " + path);
//            }
//            props.load(is);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load properties: " + path, e);
//        }
//    }
//
//    /* ===== Framework properties ===== */
//
//    public static String getBrowserName() {
//        return configProps.getProperty("browser.name");
//    }
//
//    public static boolean isHeadless() {
//        return Boolean.parseBoolean(
//                configProps.getProperty("browser.headless", "false"));
//    }
//
//    public static int getExplicitWait() {
//        return Integer.parseInt(
//                configProps.getProperty("explicit.wait", "10"));
//    }
//
//    /* ===== Environment properties ===== */
//
//    public static String getAppUrl() {
//        return envProps.getProperty("app.url");
//    }
//
//    public static String getUsername() {
//        return envProps.getProperty("app.username");
//    }
//
//    public static String getPassword() {
//        return envProps.getProperty("app.password");
//    }
//}




package com.koustav.sdetqa.opencart.config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties configProps = new Properties();
    private static final Properties envProps = new Properties();

    static {
        loadProperties("config/config.properties", configProps);

        String env = System.getProperty("env", "qa");
        loadProperties("config/" + env + ".properties", envProps);
    }

    private ConfigReader() {}

    private static void loadProperties(String path, Properties props) {
        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(path)) {

            if (is == null) {
                throw new RuntimeException("Property file not found: " + path);
            }
            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties: " + path, e);
        }
    }

    /**
     * Generic method to get property value
     * Priority:
     * 1. System Property (CI/CD override)
     * 2. Env Property
     * 3. Config Property
     */
    public static String get(String key) {

        // 1️⃣ Check System property override
        String value = System.getProperty(key);

        if (value == null) {
            // 2️⃣ Check env properties
            value = envProps.getProperty(key);
        }

        if (value == null) {
            // 3️⃣ Check config properties
            value = configProps.getProperty(key);
        }

        if (value == null) {
            throw new RuntimeException("Property not found: " + key);
        }

        return value.trim();
    }

    // ===== Typed Helpers =====

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}









