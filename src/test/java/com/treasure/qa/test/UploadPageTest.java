package com.treasure.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.treasure.qa.base.TestBase;
import com.treasure.qa.pages.HomePage;
import com.treasure.qa.pages.LoginPage;
import com.treasure.qa.pages.UploadPage;

public class UploadPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	UploadPage uploadPage;
	String uploadFilePath = prop.getProperty("filePath");
	
	public UploadPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void uploadFile(){
		uploadPage = homePage.uploadFile(absolutePath + uploadFilePath);
		String uploadMsg = uploadPage.fileTotalCount.getText();
		Assert.assertTrue(uploadMsg.equals("Showing  1  /  1  item"));
	}
	
	@Test(priority=2)
	public void downloadFile(){
		driver.navigate().refresh();
		uploadPage.dropList.click();
		uploadPage.btnDownload.click();
		Assert.assertTrue(uploadPage.downloadFinishWindow.isDisplayed());
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
