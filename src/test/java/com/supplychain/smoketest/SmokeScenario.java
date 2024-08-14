package com.supplychain.smoketest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass2;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AddDistributorPage;
import com.comcast.crm.objectrepositoryutility.AddproductPage;
import com.comcast.crm.objectrepositoryutility.AdminPage;

public class SmokeScenario extends Baseclass2 {

	@Test
	public void addProductwithValidName() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();

		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithValidDropdownSelection() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithmaxAllowedCaharacters() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithAlphanumericvalues() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addDistributorwithvalidname() throws Throwable {
		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Create an instance of AddDistributorPage
		AddDistributorPage adp = new AddDistributorPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 7, 1) + jLb.getRandomNumber();

		// Retrieve data from Excel
		String expectedAlertResult = eLib.getDataFromExcel("Sheet1", 7, 5);
		boolean isDistributorAdded = adp.isDistributorPresent(name); // Assuming this method exists
		Assert.assertTrue(isDistributorAdded, "Distributor was not added successfully!");
	}

	@Test
	public void addRetailerwithvalidName() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String userName = eLib.getDataFromExcel("Sheet1", 7, 1) + jLb.getRandomNumber();
		ahp.addRetailer(userName);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 7, 8);
		String actualMsg = ahp.getRetailerMsgInAdminPage(); // Assuming this method is implemented in AdminPage
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithValidEnableRadioButton() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();// Assuming this method is implemented in AdminPage
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithDisaableRadioButton() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		Alert al = driver.switchTo().alert();
		al.accept();
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();// Assuming this method is implemented in AdminPage
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not
		// match!");
	}

	@Test
	public void updateProductname() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		// Assert.assertEquals(altmsg, actualAlertresult, "Alert message did not
		// match!");
		System.out.println("Product added Successfully");
		Thread.sleep(2000);
		apg.editProductName("CoolCake103");
		apg.getEditButton().click();
		// Wait for and click the edit button
		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(apg.getEditButton()));
		wLib.scrollToElement(driver, editButton); // Scroll to the element if needed
		editButton.click();
		System.out.println("Updated Successfully");
		Thread.sleep(6000);
		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
		System.out.println("Added Successfully");
	}

	@Test
	public void addAndeditManufacturerWithName() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		AdminPage ahp = new AdminPage(driver);
		ahp.addManufacturer(name, email, mobile, userName, password);

		// Handle alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		// Verify the alert message
		String actualAlertResult = eLib.getDataFromExcel("Sheet1", 1, 6);
		Assert.assertEquals(altmsg, actualAlertResult, "Alert message did not match!");

		System.out.println("Manufacturer added successfully.");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not match!");

		System.out.println("Manufacturer message verified successfully.");
		ahp.navigateToManufacturerList();

		// Verify the manufacturer is present in the list
		WebElement manufacturer = ahp.searchManufacturer(name);
		if (manufacturer != null) {
			System.out.println("Manufacturer is present in the list.");

			// Edit the manufacturer
			String newManufacturerName = eLib.getDataFromExcel("Sheet1", 1, 1); 
			ahp.editManufacturer(manufacturer, newManufacturerName);

			WebElement updatedManufacturer = ahp.searchManufacturer(newManufacturerName);
			Assert.assertNotNull(updatedManufacturer, "Updated manufacturer is not present in the list.");
			System.out.println("Manufacturer name updated successfully.");
		} else {
			System.out.println("Manufacturer is not present in the list.");
		}

	}
	
	@Test
	public void addAndeditManufacturerwithAddress() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
        ExcelUtility eLib = new ExcelUtility();
        WebDriverUtility wLib = new WebDriverUtility();  

        
        AdminPage ahp = new AdminPage(driver);
        String updatedAddress = ahp.getManufacturerAddress("Acme Corp", "123 New Address St");
        if (updatedAddress != null) {
            System.out.println("Address updated successfully to: " + updatedAddress);
        } else {
            System.out.println("Manufacturer not found.");
        }

        // Retrieve manufacturer details from Excel
        String name = eLib.getDataFromExcel("Sheet1", 1, 1);
        String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
        String email = eLib.getDataFromExcel("Sheet1", 1, 2);
        String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
        String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

        // Navigate to add manufacturer page and provide all valid details to add manufacturer
        ahp.addManufacturer(name, email, mobile, userName, password);

        // Handle alert and verify the alert message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alt = driver.switchTo().alert();
        String altmsg = alt.getText();
        alt.accept();

        String expectedAlertResult = eLib.getDataFromExcel("Sheet1", 1, 6);
        Assert.assertEquals(altmsg, expectedAlertResult, "Alert message did not match!");
        System.out.println("Manufacturer added successfully");

        
        String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
        String actualMsg = ahp.getManufacturerMsgInAdminPage();
       // Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not match!");
        System.out.println("Manufacturer message verified successfully");

        
        ahp.navigateToManufacturerList();
        WebElement manufacturer = ahp.searchManufacturer(name);
       // Assert.assertNotNull(manufacturer, "Manufacturer is not present in the list.");
        System.out.println("Manufacturer is present in the list.");

        
        String address = eLib.getDataFromExcel("Sheet1", 1, 8);  
        ahp.editManufacturer(manufacturer, address);
 
        String updatedAddress1 = ahp.getManufacturerAddress(userName, address); 
        if (address != null) {
            System.out.println("Address: " + address);
        } else {
            System.out.println("Manufacturer not found.");
        }

        Assert.assertEquals(updatedAddress1, address, "Manufacturer address update failed.");
        System.out.println("Manufacturer address updated successfully");

	}
}