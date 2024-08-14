package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest {

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
		
		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);

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

		//Step 1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);

		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME,PASSWORD);
//===================================================================================================
		//Step 2: navigate to organization module
		HomePage hp=new HomePage(driver);
		 hp.getOrgLink().click();
		
		
		//Step 3: Click on "create Organization" Button
		 OrganizationsPage  op=new OrganizationsPage(driver);
		 op.getCreateNewOrgBtn().click();
		 
		//Step 4: enter all the details and create new organization
		 CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		 cnop.createOrg(orgName);

		//verify Header msg expected result
		 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		 String actHeaderName = oip.getHeaderMsg().getText();
		 if(actHeaderName.contains(orgName))
		 {
			 System.out.println(orgName+" name is verified == PASS");
		 }
		 else
		 {
			 System.out.println(orgName+" name is not verified == FAIL");
		 }
		 
		 //step 5:
		 hp.getContactLink().click();
		 
		 //step 6:
		CreateContactPage cp=new CreateContactPage(driver);
		 cp.getContactBtn().click();
		 
		 //step 7:
		 CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		 ccp.createContactWithOrg(contactLastName,orgName);
		 
		// Verify header orgName info Expected Result
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actOrgName);
			if (actOrgName.trim().equals(orgName)) {
				System.out.println(orgName + "information is created==PASS");
			} else {
				System.out.println(orgName + "information is not created==FAIL");
			}
		 
		hp.logout();
		
		driver.quit();

	}


}
