 package com.treasure.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.treasure.qa.base.TestBase;
import com.treasure.qa.pages.HomePage;
import com.treasure.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test
	public void loginWithValidId() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertTrue(homePage.welcomeMsg.isDisplayed());	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
