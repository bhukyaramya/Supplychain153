package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CONTACTinfoPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.genericutility.BaseClass;
/**
 * 
 * @author Ramya Bhukya
 * 
 */



public class CreateContactTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void createContactTest() throws Throwable {

		// Read testScript data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// Step 3: Click on "create Organization" Button
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactBtn().click();

		// Step 4: enter all the details and create new organization
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);

		// cncp.createLastName(lastName);
		cncp.createLastName(lastName);

		// verify Header msg expected result
		CONTACTinfoPage cip = new CONTACTinfoPage(driver);

		String actHeader = cip.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		String actLastName = cip.getLastNameHeaderMsg().getText();
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actLastName, lastName);
		assertObj.assertAll();

		// String actHeader = driver.findElement(By.id("dvHeaderText")).getText();
//		if (actHeader.equals(lastName)) {
//			System.out.println(lastName + "Header is verified==PASS");
//		} else {
//			System.out.println(lastName + "Header is  not verified==FAIL");
//		}

		// String actLastName = cip.getinfoOrgName().getText();
		// SoftAssert soft = new SoftAssert();
		// soft.assertEquals(actLastName, lastName);

		// String actLastName = driver.findElement(By.id("dtlview_Last
		// Name")).getText();
//		if (actLastName.equals(lastName)) {
//			System.out.println(lastName + "information is verified==PASS");
//		} else {
//			System.out.println(lastName + "information is verified==FAIL");
//		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable {

		// Read data from Excel
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// Step 3: Click on "create Contact" Button
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactBtn().click();

		// Step 4: enter last name and create new contact and date
		String endDate = jLib.getSystemDateYYYYDDMM();
		String startDate = jLib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createLastName(lastName, startDate, endDate);

		// verify start date
		String actStartDate = driver.findElement(By.xpath("support_start_date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " this is verified == PASS");
		} else {
			System.out.println(startDate + " this is not verified == FAIL");
		}

		// verify end date
		String actEndDate = driver.findElement(By.xpath("support_end_date")).getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " this is verified == PASS");
		} else {
			System.out.println(endDate + " this is not verified == FAIL");
		}
		/**
		 * ContactInfopage
		 * 
		 */

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		// Read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "create Organization" Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Step 4: enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify Header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeaderName = oip.getHeaderMsg().getText();
		if (actHeaderName.contains(orgName)) {
			System.out.println(orgName + " name is verified == PASS");
		} else {
			System.out.println(orgName + " name is not verified == FAIL");
		}

		// step 5:
		hp.getContactLink().click();

		// step 6:
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactBtn().click();

		// step 7:
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createLastName(orgName);

		// Verify header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		} else {
			System.out.println(orgName + "information is not created==FAIL");
		}

	}
}
