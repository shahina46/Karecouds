package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.ForgotPage;

public class LoginPageTest extends BaseTest {

	@Test()
	public void VerifyLoginFunction() throws InterruptedException {
		DashboardPage dash_board = login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		boolean destinationPage = dash_board.logCheck();
		Assert.assertEquals(true, destinationPage);
	}

	@Test()
	public void verifyEmptyUserNameField() {
	String result=login_page.loginWithoutUserName("Admin@123");
	Assert.assertEquals("The Username field is required.", result);
	}

	@Test()
	public void verifyEmptyPasswordFiled() {
		Object result=login_page.loginWithoutPassword("superadmin@gmail.com");
		Assert.assertEquals("The Password field is required.", result);
	}

	@Test()
	public void verifyloginWithInavalidCredentials() {
		String result=login_page.loginWithInavalidCredentials("asasd@gmail.com", "dsdsdw123");
		Assert.assertEquals("Invalid Username or Password", result);
	}

	@Test()
	public void verifyForgotBtnfunction() {
	ForgotPage forgot_page=login_page.clickOnForgotBtn();
	String result=forgot_page.pageValidation();
	Assert.assertEquals("Forgot Password", result);
		
	}
}
