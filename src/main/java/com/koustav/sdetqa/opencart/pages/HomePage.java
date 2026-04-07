package com.koustav.sdetqa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.koustav.sdetqa.opencart.base.BasePage;

public class HomePage extends BasePage {

	//initialize driver 
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	//locators
	private final By myAccount = By.xpath("//span[normalize-space()='My Account']");
	private final By register = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']");
	private final By login = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
	
	
	//action methods
	
	public void clickMyAccount() {
		doClick(myAccount);
	}
	
	public void clickRegister() {
		doClick(register);
	}
	
	//business Action 
	public RegisterPage goToRegisterPage() {
	    doClick(myAccount);
	    doClick(register);
	    return new RegisterPage(driver);
	}

}
