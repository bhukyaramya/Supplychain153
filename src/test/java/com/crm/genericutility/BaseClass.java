package com.crm.genericutility;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.databseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smoke test", "regressionTest" })
	public void configBS() throws Throwable {

		System.out.println("Connect to DB and Report config");
		dbLib.getDbconnection();

		
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smoke test", "regressionTest" })
	// public void configBC(String browser) throws Throwable
	public void configBC() throws Throwable {

		System.out.println("===Launch the Browser===");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		// String BROWSER = browser;

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
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoke test", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("==Login to Application==");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smoke test", "regressionTest" })
	public void configAM() {
		System.out.println("==Logout of Application==");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoke test", "regressionTest" })
	public void configAC() throws Throwable {
		System.out.println("==Close the Browser==");
		driver.quit();

	}

	@AfterSuite(groups = { "smoke test", "regressionTest" })
	public void configAS() throws Throwable {
		System.out.println("Close the DB and Report BackUP");
		dbLib.closeDbconnection();
		
	}
}
