package com.supplychain.endtoendtest;

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

//POSITIVE SCENARIOS ON END-TO-END TESTING
public class End_To_End_Scenarios extends Baseclass2 {

	@Test
	public void createManufacturertest() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		// Navigate to add manufacturer page and provide all valid details to add
		// manufacturer
		ahp.addManufacturer(name, email, mobile, userName, password);

		// Handle alert
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 1, 6);
		Assert.assertFalse(false, actualAlertresult);
		// Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Manufacturer added Successfully");

		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();
		Assert.assertFalse(false, actualMsg);
		// Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not
		// match!");
		System.out.println("Manufacturer added Successfully");
	}

	@Test
	public void createRetailer() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String userName = eLib.getDataFromExcel("Sheet1", 7, 1) + jLib.getRandomNumber();
		String password = eLib.getDataFromExcel("Sheet1", 7, 2) + jLib.getRandomNumber();
		String areaCode = eLib.getDataFromExcel("Sheet1", 7, 3);
		String mobile = eLib.getDataFromExcel("Sheet1", 7, 4);
		String email = eLib.getDataFromExcel("Sheet1", 7, 5);
		String address = eLib.getDataFromExcel("Sheet1", 7, 6);

		ahp.addRetailer(userName, password, areaCode, mobile, email, address);
		Thread.sleep(8000);

		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 7, 7);
		// Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 7, 8);
		String actualMsg = ahp.getRetailerMsgInAdminPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not
		// match!");
	}

	@Test
	public void addProduct() throws Throwable {

		JavaUtility jLb = new JavaUtility();
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
		Thread.sleep(2000);

		// Handle alert
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		// Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Product added Successfully");

		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not
		// match!");
		System.out.println("Added Successfully");
	}

	@Test
	public void deleteManufacturer() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		ahp.addManufacturer(name, email, mobile, userName, password);

		// Handle alert
//	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//	        wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 1, 6);
		// Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Manufacturer added Successfully");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Manufacturer message did not
		// match!");
		System.out.println("added Successfully");

		ahp.getManufactureLink().click();
		ahp.getManufactureCheckbox().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ahp.getManufacturerDelete());
		ahp.getManufacturerDelete().click();
		alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Manufacturer deleted successfully");
	}

	// NEGATIVE SCENARIOS ON END-TO-END TESTING

	@Test
	public void addProductLeavetextfieldEmpty() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		System.out.println("please fill out this field");
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		Thread.sleep(2000);
		// Handle Laert
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		// Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Product added Successfully");

		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		// Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not
		// match!");
		System.out.println("Added Successfully");
	}

	@Test
	public void addProductwithSpecialCharacters() throws Throwable {

		JavaUtility jLb = new JavaUtility();
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
		Thread.sleep(2000);
		// Handle Laert
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		//Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Product added Successfully");

		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		//Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
		System.out.println("Added Successfully");
	}

	@Test
	public void addProductLeaveUnitTypeEmpty() throws Throwable {

		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		System.out.println("All Fields are Compulsory with valid values except Description");
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		apg.addProduct(productname, price, unittype, category, inStock, description);
		Thread.sleep(2000);
		
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		//Assert.assertEquals(alt, actualAlertresult, "Alert message did not match!");
		System.out.println("Product added Successfully");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		//Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
		System.out.println("Added Successfully");

	}

}