package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.SupplychainHomePage;
import com.comcast.crm.objectrepositoryutility.Supplychain_Loginpage;

public class Baseclass2 {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public  WebDriver driver = null;
	public static WebDriver sdriver = null;


	@BeforeSuite(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	public void configBS() throws Throwable {
		System.out.println("Connect to DB and Report config");
		dbLib.getDbconnection();
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	//public void configBC(String browser) throws Throwable{
	public void configBC() throws Throwable {

		System.out.println("===Launch the Browser===");

		//insted of recieveing the data from the properties file iam going recieve from cmd line.
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		
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
		sdriver = driver;
	}

	@BeforeMethod(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	public void configBM() throws Throwable {
		
		System.out.println("==Login to Application==");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
	
		driver.get(URL);
		Supplychain_Loginpage lp = new Supplychain_Loginpage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	public void configAM() {
		System.out.println("==Logout of Application==");
		SupplychainHomePage hp = new SupplychainHomePage(driver);
		hp.logOut();
	}

	@AfterClass(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	public void configAC() throws Throwable {
		System.out.println("==Close the Browser==");
		driver.quit();

	}

	@AfterSuite(groups={"smokeTest","functionalTest","integrationTest","endtoendTest"})
	public void configAS() throws Throwable {
		System.out.println("Close the DB and Report BackUP");
		dbLib.closeDbconnection();

	}
}
