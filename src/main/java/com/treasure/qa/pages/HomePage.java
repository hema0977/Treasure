package com.treasure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treasure.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[text()='Welcome to Treasure']")
	public WebElement welcomeMsg;
	
	@FindBy(css=".user-menu-button")
	public WebElement btnUserMenu;
	
	@FindBy(css=".add-file-button")
	public WebElement btnAddFile;
	
	@FindBy(xpath="//*[text()='Logout']")
	public WebElement btnLogout;
	
	@FindBy(xpath="//*[text()='Upload files']")
	public WebElement btnUploadFileOption;
	
	@FindBy(css=".cdk-overlay-pane>div>div>input:nth-of-type(1)")
	public WebElement btnUploadFiles;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public UploadPage uploadFile(String filePath){
		btnAddFile.click();
		btnUploadFiles.sendKeys(filePath);
		return new UploadPage();
	}

}
