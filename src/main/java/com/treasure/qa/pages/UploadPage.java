package com.treasure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treasure.qa.base.TestBase;

public class UploadPage extends TestBase {
	
	@FindBy(css=".toolbar-files-total")
	public WebElement fileTotalCount;
	
	@FindBy(id="cdk-drop-list-0")
	public WebElement dropList;
	
	@FindBy(xpath="//*[text()='Download']")
	public WebElement btnDownload;
	
	@FindBy(xpath="//*[text()='All downloads finished']")
	public WebElement downloadFinishWindow;
	
	
	//Page Factory
	public UploadPage(){
		PageFactory.initElements(driver, this);
	}

}
