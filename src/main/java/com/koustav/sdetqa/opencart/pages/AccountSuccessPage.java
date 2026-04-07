package com.koustav.sdetqa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.koustav.sdetqa.opencart.base.BasePage;

public class AccountSuccessPage extends BasePage {
	
	 public AccountSuccessPage(WebDriver driver) {
	        super(driver);
	    }

    private final By successMsg =
        By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

   

    public String getSuccessMessage() {
        return doGetText(successMsg);
    }
}
