package com.koustav.sdetqa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.koustav.sdetqa.opencart.base.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// locators
	private final By txtFirstName = By.xpath("//input[@id='input-firstname']");
	private final By txtLastName = By.xpath("//input[@id='input-lastname']");
	private final By txtEmail = By.xpath("//input[@id='input-email']");
	private final By txtTelephone = By.xpath("//input[@id='input-telephone']");
	private final By txtPassword = By.xpath("//input[@id='input-password']");
	private final By txtConfirmPassword = By.xpath("//input[@id='input-confirm']");
	private final By radioYes = By.xpath("//label[normalize-space()='Yes']");
	private final By radioNo = By.xpath("//label[normalize-space()='No']");
	private final By chkPrivacyPolicy = By.xpath("//input[@name='agree']");
	private final By btnContinue = By.xpath("//input[@value='Continue']");
	private final By confirmationMsg = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	
	
	/*
	 * ✅ BEST PRACTICE FOR YOUR CASE (Recommended)
		🔹 Keep atomic methods private
		🔹 Expose only business methods as public
	 * 
	 * 
	 */

	 /* ===================== ATOMIC ACTIONS ===================== */

    private void enterFirstName(String firstName) {
        doSendKeys(txtFirstName, firstName);
    }

    private void enterLastName(String lastName) {
        doSendKeys(txtLastName, lastName);
    }

    private void enterEmail(String email) {
        doSendKeys(txtEmail, email);
    }

    private void enterTelephone(String phone) {
        doSendKeys(txtTelephone, phone);
    }

    private void enterPassword(String password) {
        doSendKeys(txtPassword, password);
    }

    private void enterConfirmPassword(String password) {
        doSendKeys(txtConfirmPassword, password);
    }

    private void selectNewsletterYes() {
        doClick(radioYes);
    }

    private void selectNewsletterNo() {
        doClick(radioNo);
    }

    private void acceptPrivacyPolicy() {
        doClick(chkPrivacyPolicy);
    }

    private void clickContinue() {
        doClick(btnContinue);
    }

    /* ===================== BUSINESS ACTION ===================== */

    public AccountSuccessPage registerUser(String firstName,
                                           String lastName,
                                           String email,
                                           String phone,
                                           String password,
                                           boolean subscribe) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(password);
        enterConfirmPassword(password);

        if (subscribe) {
            selectNewsletterYes();
        } else {
            selectNewsletterNo();
        }

        acceptPrivacyPolicy();
        clickContinue();

        return new AccountSuccessPage(driver);
    }

}
