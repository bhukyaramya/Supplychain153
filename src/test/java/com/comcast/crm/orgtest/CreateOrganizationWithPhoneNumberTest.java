package com.comcast.crm.orgtest;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationWithPhonenumberPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class CreateOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws Throwable {
		
		/* create Object */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		// read common data from Property file

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME= fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("contact", 7, 3);
		
				WebDriver driver = null;
                //polymorphism concept
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

				//Step 3: Click on "create Organization" Button
				OrganizationsPage cnp = new OrganizationsPage(driver);
				cnp.getCreateNewOrgBtn();


				//Step 4: enter all the details and create new organization
				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.createOrg(orgName, phoneNumber);
				
				//verify Header msg expected result
				
				String actPhoneNum = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(actPhoneNum.contains(phoneNumber))
				{
					System.out.println(phoneNumber+" phone number is verified == PASS");
				}
				else
				{
					System.out.println(phoneNumber+" phone number is not verified == FAIL");
				}
				
				hp.logout();
				
				driver.quit();
			}

}
