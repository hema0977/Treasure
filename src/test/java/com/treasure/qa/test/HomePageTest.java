package com.treasure.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.treasure.qa.base.TestBase;
import com.treasure.qa.pages.HomePage;
import com.treasure.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void setUP(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void logout(){
		homePage.btnUserMenu.click();
		homePage.btnLogout.click();
		Assert.assertTrue(loginPage.btnLogin.isDisplayed());	
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
