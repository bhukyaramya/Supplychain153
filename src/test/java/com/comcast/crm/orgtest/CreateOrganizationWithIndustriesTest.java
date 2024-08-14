package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationWithIndustriesPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws Throwable {

		/* create Object */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		// read common data from Property file

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String induestry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		WebDriver driver = null;
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

		// step1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME,PASSWORD);

		// step 2 :navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 :click on "create organization module
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn();

		// Step 4: enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, induestry);

		// verify Header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeaderName = oip.getHeaderMsg().getText();
		if (actHeaderName.contains(orgName)) {
			System.out.println(orgName + " name is verified == PASS");
		} else {
			System.out.println(orgName + " name is not verified == FAIL");
		}

		// verify industry name expected result
		String actIndustry = oip.getIndustryDB().getText();
		if (actIndustry.contains(induestry)) {
			System.out.println(induestry + " information is verified == PASS");
		} else {
			System.out.println(induestry + " information is not verified == FAIL");
		}

		// step5 : logout
		hp.logout();
		driver.quit();

	}

}
