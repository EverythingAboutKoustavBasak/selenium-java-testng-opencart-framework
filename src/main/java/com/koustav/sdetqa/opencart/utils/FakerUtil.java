package com.koustav.sdetqa.opencart.utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    private static final Faker faker = new Faker();

    private FakerUtil() {
        // prevent object creation
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPhoneNumber() {
        // OpenCart expects numeric phone
        return faker.number().digits(10);
    }

    public static String getStrongPassword() {
        return faker.internet().password(
                8,   // min length
                12,  // max length
                true,  // include uppercase
                true,  // include special chars
                true   // include digits
        );
    }
}
