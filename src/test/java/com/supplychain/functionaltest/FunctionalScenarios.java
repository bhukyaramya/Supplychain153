package com.supplychain.functionaltest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass2;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AddproductPage;
import com.comcast.crm.objectrepositoryutility.AdminPage;

public class FunctionalScenarios extends Baseclass2 {

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
	public void addProductwithmaxAllowedCaharacters() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 12) + jLib.getRandomNumber();
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
		String productname = eLib.getDataFromExcel("Sheet1", 4, 11) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithNumbers() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 9) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithSpecialCharacters() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 10) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void selectUnitTypefromdropdown() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 10) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void selectFirstUnittypeFromdropdown() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 10) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 13);
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void selectLastUnittypefromDropdown() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 10) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 14);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", unittype);
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not
		// match!");
	}

	// functional Negative Scenarios
	@Test
	public void addProductwithZeros() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 15) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithHtmlTags() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 16) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithDuplicateName() throws Throwable {

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
	public void addProductwithBlankTextfield() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 17) + jLib.getRandomNumber();
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void addProductwithUnselectradioButton() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 18);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		System.out.println("it will throws NullpointerException");
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
		apg.addProduct(productname, price, unittype, category, inStock, description);

		String expectedErrorMeString = eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString = apg.getErrorMessage();
		Assert.assertEquals(actualErrorMessString, expectedErrorMeString, "Error message did not match!");
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
	public void addManufacturerwithoutNameTextfield() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 8);
		ahp.addManufacturer(name);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getRetailerMsgInAdminPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not match");

	}

//Negative Functional Scenarios
	@Test
	public void addManufacturerwithInvalidcontactNumber() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 9);
		System.out.println("valid name,Username,password,Mobile is compulsory");
		ahp.addManufacturer(name, userName, email, password, mobile);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getRetailerMsgInAdminPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not match");

	}

	@Test
	public void addProductandMultiselecttheDropdown() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Initialize page objects
		AddproductPage apg = new AddproductPage(driver);

		// Retrieve product details from Excel
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		System.out.println("All Fields are Compulsory with valid values except Description");
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 19);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 7);
		String actuslMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actuslMsg, expectedMsg, "Manufacturer message did not match");
	}

	@Test
	public void selectFirstUnittypeWithoutInternet() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 10) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		apg.getAddProductLink().click(); // Navigate to the Add Product page
		apg.addProduct(productname);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
	}

	@Test
	public void userShouldSelectSingleRadioButton() throws Throwable {

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
	public void addProductwithInvalidPrice() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 20) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 19);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();// Assuming this method is implemented in AdminPage
		Assert.assertEquals(actualMsg, expectedMsg, "Product message did not match!");
	}

	@Test
	public void editManufacturerwithName() throws Throwable {
		
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

		WebElement manufacturer = ahp.searchManufacturer(name);
		if (manufacturer != null) {
			System.out.println("Manufacturer is present in the list.");

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
	public void editmanufacturerWithAddress() throws Throwable {

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

		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		ahp.addManufacturer(name, email, mobile, userName, password);

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
		Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not match!");
		System.out.println("Manufacturer message verified successfully");

		ahp.navigateToManufacturerList();
		WebElement manufacturer = ahp.searchManufacturer(name);
		Assert.assertNotNull(manufacturer, "Manufacturer is not present in the list.");
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
	
	@Test
	public void editmanufacturerWithEmail() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		WebElement updatedEmail = ahp.getManufacturerEmail("Acme Corp", "123 New Address St");
		if (updatedEmail != null) {
			System.out.println("Email updated successfully to: " + updatedEmail);

		} else {
			System.out.println("Email not found.");
		}

		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		ahp.addManufacturer(name, email, mobile, userName, password);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		String expectedAlertResult = eLib.getDataFromExcel("Sheet1", 1, 6);
		Assert.assertEquals(altmsg, expectedAlertResult, "Alert message did not match!");
		System.out.println("Email added successfully");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();
		Assert.assertEquals(actualMsg, expectedMsg, "Email message did not match!");
		System.out.println("Email message verified successfully");

		ahp.navigateToManufacturerList();
		WebElement manufacturer = ahp.searchManufacturer(email);
		Assert.assertNotNull(manufacturer, "Email is not present in the list.");
		System.out.println("Email is present in the list.");

		String email1 = eLib.getDataFromExcel("Sheet1", 1, 8);
		ahp.editManufacturer(manufacturer, email);

		String updatedEmail1 = ahp.getManufacturerAddress(userName, email);
		if (email!= null) {
			System.out.println("Address: " + email);
		} else {
			System.out.println("Manufacturer not found.");
		}

		Assert.assertEquals(updatedEmail1, email, "Manufacturer Email update failed.");
		System.out.println("Manufacturer email updated successfully");
	}
	
	@Test
	public void editManufacturerWithPhone() throws Throwable {
	
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		AdminPage ahp = new AdminPage(driver);
		WebElement updatedPhone = ahp.getManufacturerPhone("Acme Corp", "8096246721");
		if (updatedPhone != null) {
			System.out.println("Phone updated successfully to: " + updatedPhone);

		} else {
			System.out.println("Phone not found.");
		}

		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);
		
		ahp.addManufacturer(name, email, mobile, userName, password);
		Alert al =driver.switchTo().alert();
		al.accept();
		
		String expectedResult=eLib.getDataFromExcel("Sheet1", 1, 6);
		String actualResult=ahp.getManufacturerMsgInAdminPage();
		Assert.assertEquals(expectedResult,actualResult,"Phone is not matched in addmanufacturer ");
	}
	
	@Test
	public void addmanufacturernamewithSpecialCharacters() throws Throwable {
		
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		AdminPage ahp=new AdminPage(driver);
		
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);
		
		ahp.addManufacturer(name, email, mobile, userName, password);
		Alert al =driver.switchTo().alert();
		al.accept();
		
		String actualResult=eLib.getDataFromExcel("Sheet1", 1, 6);
		String expectedResult=ahp.getManufacturerMsgInAdminPage();
		Assert.assertEquals(actualResult,expectedResult,"Manufacturer name with SpecialCharacters");
		}
	}
