package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.genericutility.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	
   @Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
	   
	  UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// step 2 :navigate organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 :click on "create organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+"read data from Excel");

		// verify Header msg Expected Result
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		
//		if (actOrgName.contains(orgName)) {
//
//			System.out.println(orgName + "name is verified==PASS");
//		} else {
//			System.out.println(orgName + "name is not verified==FAIL");
//		}
//
//		// step5 : logout
//
//		hp.logout();
//		driver.quit();

	}
   
   	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumberTest() throws Throwable {

		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("contact", 7, 3);

		// step 2 :navigate organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "create Organization" Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn();

		// Step 4: enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNumber);

		// verify Header msg expected result

		String actPhoneNum = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (actPhoneNum.contains(phoneNumber)) {
			System.out.println(phoneNumber + " phone number is verified == PASS");
		} else {
			System.out.println(phoneNumber + " phone number is not verified == FAIL");
		}
		
		//verify Header phone Number info Expected Result
//		UtilityClassObject.getTest().log(Status.INFO,"verify the phone Number");
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		String actOrgName = oip.getHeaderMsg().getText();
//		Assert.assertEquals(true, actOrgName.contains(orgName));
//		String actPhoneNumber = oip.getPhoneNumebr().getText();
//		Assert.assertEquals(actOrgName,phoneNumber);
//		UtilityClassObject.getTest().log(Status.PASS,actPhoneNumber+"==>verify the phone Number<==");

		
	}
   	
   	
   	@Test(groups = "regressionTest")
	public void createOrgWithIndustriesTest() throws Throwable {

		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String induestry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
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
	}

}
