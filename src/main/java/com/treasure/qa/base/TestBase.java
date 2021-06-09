package com.treasure.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.treasure.qa.utils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String absolutePath = System.getProperty("user.dir");
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(absolutePath + "/src/main/java/com/treasure/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", absolutePath + "/driver/chromedriver");
			driver=new ChromeDriver();//launching chrome
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", absolutePath + "/driver/geckodriver");
			driver=new FirefoxDriver();//launching firefox
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

}
