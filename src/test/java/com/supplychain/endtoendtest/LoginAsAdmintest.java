package com.supplychain.endtoendtest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Supplychain_Loginpage;

public class LoginAsAdmintest {
	
	public static void main(String[] args) throws Throwable {


	/* create Object */
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	// read common data from Property file
	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME = fLib.getDataFromPropertiesFile("username");
	String PASSWORD = fLib.getDataFromPropertiesFile("password");
	
	

	WebDriver driver=null;
	// polymorphism concept
	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	} else if (BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	} else {
		driver = new ChromeDriver();
	}

	//Step 1: login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(URL);
	
	Supplychain_Loginpage lp=new Supplychain_Loginpage(driver);
	lp.loginToapp(URL, USERNAME, PASSWORD);
	
	System.out.println("Logined as a Admin Successfully");
	
	driver.quit();
}
}