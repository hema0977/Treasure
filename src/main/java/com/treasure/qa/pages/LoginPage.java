package com.treasure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treasure.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory 
	@FindBy(id="mat-input-0")
	public WebElement username;
	
	@FindBy(id="mat-input-1")
	public WebElement password;
	
	@FindBy(id="signin-button")
	public WebElement btnLogin;
	
	
	//Initializing page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage login(String email, String pass){
		username.sendKeys(email);
		password.sendKeys(pass);
		btnLogin.click();
		
		return new HomePage();
		
	}
	

}
