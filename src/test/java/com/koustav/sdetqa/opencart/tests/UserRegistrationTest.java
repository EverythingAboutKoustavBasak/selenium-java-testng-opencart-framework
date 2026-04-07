package com.koustav.sdetqa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.koustav.sdetqa.opencart.base.BaseTest;
import com.koustav.sdetqa.opencart.pages.AccountSuccessPage;
import com.koustav.sdetqa.opencart.utils.FakerUtil;

public class UserRegistrationTest extends BaseTest{
	
	
	@Test(description = "Verify user can register with valid details")
	public void verify_accountRegistrationWithValidInput() {
		
//		 AccountSuccessPage successPage =
//	                homePage
//	                    .goToRegisterPage()
//	                    .registerUser(
//	                        "ABC",
//	                        "DEY",
//	                        "koustav" + System.currentTimeMillis() + "@test.com",
//	                        "1234567898",
//	                        "Test@123",
//	                        true
//	                    );
		
		AccountSuccessPage successPage =
			homePage
	        .goToRegisterPage()
	        .registerUser(
		            FakerUtil.getFirstName(),
		            FakerUtil.getLastName(),
		            FakerUtil.getEmail(),
		            FakerUtil.getPhoneNumber(),
		            FakerUtil.getStrongPassword(),
		            true
	        		);

	        Assert.assertEquals(
	                successPage.getSuccessMessage(),
	                "Your Account Has Been Created!"
	        );
	
	}
}