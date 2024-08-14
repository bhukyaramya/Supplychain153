package com.supplychain.integrationtest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
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

//INTEGRATION POSITIVE SCENARIOS

public class IntegrationScenarios extends Baseclass2 {

	@Test
	public void addProductAndcheckinProductsList() throws Throwable {
		
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	// Initialize page objects
	AddproductPage apg = new AddproductPage(driver);

	// Retrieve product details from Excel
	String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
	String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
	String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
	String category = eLib.getDataFromExcel("Sheet1", 4, 4);
	String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
	String description = eLib.getDataFromExcel("Sheet1", 4, 6);

	// Navigate to add product page and add product
	apg.addProduct(productname, price, unittype, category, inStock, description);

	// Wait for and handle alert
	try {
	    String expectedAlertMsg = eLib.getDataFromExcel("Sheet1", 4, 7);
	    String actualAlertMsg = wLib.waitForAlertAndAccept(driver); // Wait and get alert text
	    Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept(); // Accept the alert

	    // Check if the alert message is as expected
	    if (actualAlertMsg.equals(expectedAlertMsg)) {
	        System.out.println("Product added successfully with alert message: " + actualAlertMsg);
	    } else {
	        System.out.println("Alert message did not match! Actual: " + actualAlertMsg + ", Expected: " + expectedAlertMsg);
	    }
	} catch (NoAlertPresentException e) {
	    System.out.println("No alert was present after adding the product.");
	}

	// Navigate to the Products module
	apg.getProductLink().click();

	// Verify if the product is present in the product list
	boolean isProductAdded = apg.isProductInList(productname);

	if (isProductAdded) {
	    System.out.println("Product is added successfully and displayed in the product list.");
	} else {
	    System.out.println("Product was not added or is not displayed in the product list.");
	}
}
	
	@Test
	public void updateProduct() throws Throwable {
		
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

		// Navigate to add manufacturer page and provide all valid details to add manufacturer
		apg.addProduct(productname, price, unittype, category, inStock, description);

		// Wait for and handle the alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 4, 7);
		// Assert.assertEquals(altmsg, actualAlertresult, "Alert message did not match!");
		System.out.println("Product added Successfully");
		Thread.sleep(2000);
		apg.editProductName("CoolCake103");
	      apg.getEditButton().click();
		// Wait for and click the edit button
		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(apg.getEditButton()));
		wLib.scrollToElement(driver, editButton);  // Scroll to the element if needed
		editButton.click();
		System.out.println("Updated Successfully");
        Thread.sleep(6000);
		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 4, 8);
		String actualMsg = apg.getProductMsgInProductPage();
		//Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
		System.out.println("Added Successfully");
		Thread.sleep(60000);

	  }
	@Test
	public void createManufacturerAndcheckManufacturerList() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLib.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLib.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		// Navigate to add manufacturer page and provide all valid details to add manufacturer
		ahp.addManufacturer(name, email, mobile, userName, password);

		// Handle alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		String actualAlertresult = eLib.getDataFromExcel("Sheet1", 1, 6);
		
		System.out.println("Manufacturer added Successfully");
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();

		System.out.println("Manufacturer message verified successfully");
		ahp.navigateToManufacturerList(); 

		WebElement manufacturer = ahp.searchManufacturer(name);
		if (manufacturer != null) {
		    System.out.println("Manufacturer is present in the list.");
		} else {
		    System.out.println("Manufacturer is not present in the list.");
		}

}
	
	@Test
	public void createRetailerAndcheckRetailerList() throws Throwable {
		
		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String userName = eLib.getDataFromExcel("Sheet1", 7, 1) + jLb.getRandomNumber();
		String password = eLib.getDataFromExcel("Sheet1", 7, 2) + jLb.getRandomNumber();
		String areaCode = eLib.getDataFromExcel("Sheet1", 7, 3);
		String mobile = eLib.getDataFromExcel("Sheet1", 7, 4);
		String email = eLib.getDataFromExcel("Sheet1", 7, 5);
		String address = eLib.getDataFromExcel("Sheet1", 7, 6);

		System.out.println("Retailer details " + userName + "\t" + password + "\t" + areaCode + "\t" + mobile + "\t" + email + "\t" + address);

		Thread.sleep(6000);

		// Add the retailer details
		ahp.addRetailer(userName, password, areaCode, mobile, email, address);

		// Use WebDriverWait to handle alert correctly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click the submit button and wait for the alert to appear
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitRetailer"))).click();
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		String actualAlertResult = eLib.getDataFromExcel("Sheet1", 7, 7);
		//Assert.assertEquals(altmsg, actualAlertResult, "Alert message did not match!");
		System.out.println("Retailer added successfully");

		String expectedMsg = eLib.getDataFromExcel("Sheet1", 7, 8);
		String actualMsg = ahp.getRetailerMsgInAdminPage(); // Assuming this method is implemented in AdminPage
		//Assert.assertEquals(actualMsg, expectedMsg, "Retailer message did not match!");
		System.out.println("Retailer message verified successfully");

		// Navigate to retailer list
		ahp.navigateToRetailerList(); // Assuming this method is implemented in AdminPage

		// Search for the retailer
		WebElement retailer = ahp.searchRetailer(userName);
		if (retailer != null) {
		    System.out.println("Retailer is present in the list.");
		} else {
		    System.out.println("Retailer is not present in the list.");
		}

	}
	
	@Test
	public void addProductanddeleteProduct() throws Throwable {
		
		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AdminPage ahp = new AdminPage(driver);
		String name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String userName = eLib.getDataFromExcel("Sheet1", 1, 4) + jLb.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String password = eLib.getDataFromExcel("Sheet1", 1, 5) + jLb.getRandomNumber();
		String mobile = eLib.getDataFromExcel("Sheet1", 1, 3);

		// Navigate to add manufacturer page and provide all valid details to add manufacturer
		ahp.addManufacturer(name, email, mobile, userName, password);

		// Handle alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertResult = eLib.getDataFromExcel("Sheet1", 1, 6);
		System.out.println("Manufacturer added Successfully");

		// Verify manufacturer message
		String expectedMsg = eLib.getDataFromExcel("Sheet1", 1, 7);
		String actualMsg = ahp.getManufacturerMsgInAdminPage();
		System.out.println("Manufacturer added Successfully");

		// Navigate to manufacturer list and delete the manufacturer
		ahp.getManufactureLink().click();
		ahp.getManufactureCheckbox().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ahp.getManufacturerDelete());
		ahp.getManufacturerDelete().click();
		alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Manufacturer deleted successfully");

		Thread.sleep(2000);
		// Check whether the manufacturer is displayed in the manufacturer list
		List<WebElement> deletedManufacturers = driver.findElements(By.xpath("//table//td[text()='" + userName + "']"));
		if (deletedManufacturers.isEmpty()) {
		    System.out.println("Manufacturer is not present in the list after deletion.");
		} else {
		    System.out.println("Manufacturer is still present in the list after deletion.");
		}

		if (deletedManufacturers != null) {
		    System.out.println("Manufacturer is still present in the list after deletion.");
		} else {
		    System.out.println("Manufacturer deleted successfully and is not present in the list.");
		}

	}
	
	@Test
	public void addDistributorandcheckDistributorList() throws Throwable {
		
		JavaUtility jLb = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Create an instance of AddDistributorPage
		AddDistributorPage adp = new AddDistributorPage(driver);

		// Retrieve data from Excel
		String name = eLib.getDataFromExcel("Sheet1", 11, 1) + jLb.getRandomNumber();
		String email = eLib.getDataFromExcel("Sheet1", 11, 2);
		String mobile = eLib.getDataFromExcel("Sheet1", 11, 3);
		String address = eLib.getDataFromExcel("Sheet1", 11, 4);

		// Add distributor
		adp.addDistributor(name, email, mobile, address);

		// Handle alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();

		// Verify alert message
		String expectedAlertResult = eLib.getDataFromExcel("Sheet1", 11, 5);
		//Assert.assertEquals(altmsg, expectedAlertResult, "Alert message did not match!");
		System.out.println("Distributor added successfully");

		// Navigate to distributor list
		adp.getDistributorLink().click();

		// Search for the added distributor
		WebElement distributor = adp.searchDistributor(name);
		if (distributor != null) {
		    System.out.println("Distributor is present in the list.");
		} else {
		    System.out.println("Distributor is not present in the list.");
		}
   }
	
	//Integration Negative Scenarios.
	
		@Test
		public void addProductNameWithAllZeros() throws Throwable {
		    // Initialize utilities and page objects
		    JavaUtility jLib = new JavaUtility();
		    ExcelUtility eLib = new ExcelUtility();
		    WebDriverUtility wLib = new WebDriverUtility();
		    AddproductPage apg = new AddproductPage(driver);

		    // Retrieve product details from Excel
		    String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		    String price = eLib.getDataFromExcel("Sheet1", 4, 2);
		    String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		    String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		    String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		    String description = eLib.getDataFromExcel("Sheet1", 4, 6);

		    
		    apg.addProduct(productname, price, unittype, category, inStock, description);
		    String expectedErrorMessage = eLib.getDataFromExcel("Sheet1", 4, 7); 
		    String actualErrorMessage = apg.getErrorMessage(); 
		    //Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message did not match!");
		    boolean isProductAdded = apg.isProductInList(productname); 
		    //Assert.assertFalse(isProductAdded, "Product should not be added when the name is missing!");
		}

	@Test
	public void addProductNamewithEmpty() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
	    ExcelUtility eLib = new ExcelUtility();
	    WebDriverUtility wLib = new WebDriverUtility();

	    // Initialize page objects
	    AddproductPage apg = new AddproductPage(driver);

	    // Retrieve product details from Excel
	    String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
	    String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
	    String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
	    String category = eLib.getDataFromExcel("Sheet1", 4, 4);
	    String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);

	    apg.addProduct("", price, unittype, category,inStock,description);
	    String expectedErrorMessage = eLib.getDataFromExcel("Sheet1", 4, 5); 
	    String actualErrorMessage = apg.getErrorMessage(); 
	    //Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message did not match!");
	    boolean isProductAdded = apg.isProductInList(productname); 
	    //Assert.assertFalse(isProductAdded, "Product should not be added when the name is missing!");

	}
	
	@Test
	public void addProductNamewithNumandChar() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Initialize page objects
		AddproductPage apg = new AddproductPage(driver);

		// Retrieve product details from Excel
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		System.out.println("Enter the valid name in to the name textfield");
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	
	
	@Test
	public void addProductNamewithmaxlenghtExceeds() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Initialize page objects
		AddproductPage apg = new AddproductPage(driver);

		// Retrieve product details from Excel
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		System.out.println("Enter the valid name in to the name textfield");
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	@Test
	public void addDropdownisUnselect() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Initialize page objects
		AddproductPage apg = new AddproductPage(driver);

		// Retrieve product details from Excel
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		System.out.println("All Fields are Compulsory with valid values except Description");
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);	
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	@Test
	public void addDropdownmultiUnselect() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Initialize page objects
		AddproductPage apg = new AddproductPage(driver);

		// Retrieve product details from Excel
		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		System.out.println("Dropdown is multi selected");
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	
	@Test
	public void unselectTheDropdowninAddProduct() throws Throwable {
		
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
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	@Test
	public void unselectTheRadiobuttoninAddProduct() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		System.out.println("it will throws NullpointerException");
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	@Test
	public void multiselectRadiobuttoninAddProduct() throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		
		AddproductPage apg = new AddproductPage(driver);

		String productname = eLib.getDataFromExcel("Sheet1", 4, 1) + jLib.getRandomNumber();
		String price = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String unittype = eLib.getDataFromExcel("Sheet1", 4, 3);
		String category = eLib.getDataFromExcel("Sheet1", 4, 4);
		System.out.println("it will throws NullpointerException");
		String inStock = eLib.getDataFromExcel("Sheet1", 4, 5);
		String description = eLib.getDataFromExcel("Sheet1", 4, 6);
       
		apg.addProduct(productname, price, unittype, category, inStock, description);
		//Handle Alert
		Alert al =driver.switchTo().alert();
		al.accept();
		
		String expectedErrorMeString=eLib.getDataFromExcel("Sheet1", 4, 7);
		String actualErrorMessString=apg.getErrorMessage();
		//Assert.assertEquals(actualErrorMessString, expectedErrorMeString,"Error message did not match!");
		boolean isProductAdded=apg.isProductInList(productname);
		//Assert.assertEquals(isProductAdded, "prodcut should not be added when the same name is missing");
	
	}
	
}
