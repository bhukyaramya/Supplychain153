package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Manufacturer Module

	@FindBy(xpath = "//a[@href='../admin/view_manufacturer.php']")
	private WebElement manufactureLink;

	@FindBy(xpath = "//td[text()=' ammuu ']/preceding-sibling::td/input[@type='checkbox']")
	private WebElement manufactureCheckbox;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement manufacturerDelete;

	@FindBy(xpath = "//a[@href='../admin/add_manufacturer.php']")
	private WebElement manufacturerLink;

	@FindBy(id = "manufacturer:name")
	private WebElement manufacturerName;

	@FindBy(id = "manufacturer:email")
	private WebElement manufacturerEmail;

	@FindBy(id = "manufacturer:phone")
	private WebElement manufacturerPhone;

	@FindBy(id = "manufacturer:username")
	private WebElement manufacturerUsername;

	@FindBy(id = "manufacturer:password")
	private WebElement manufacturerPassword;

	@FindBy(xpath = "//input[@value='Add Manufacturer']")
	private WebElement addManufacturerButton;

	// Retailer Module
	@FindBy(xpath = "//a[@href='../admin/add_retailer.php']")
	private WebElement retailerLink;

	@FindBy(id = "retailer:username")
	private WebElement retailerUsername;

	@FindBy(id = "retailer:password")
	private WebElement retailerPassword;

	@FindBy(id = "retailer:areaCode")
	private WebElement areacodeDropdown;

	@FindBy(id = "retailer:phone")
	private WebElement retailerPhone;

	@FindBy(id = "retailer:email")
	private WebElement retailerEmail;

	@FindBy(id = "retailer:address")
	private WebElement retailerAddress;

	@FindBy(xpath = "//input[@value='Add Retailer']")
	private WebElement addRetailerButton;

	// Getters for Manufacturer Module
	public WebElement getManufacturerLink() {
		return manufacturerLink;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the manufactureLink
	 */
	public WebElement getManufactureLink() {
		return manufactureLink;
	}

	/**
	 * @return the manufactureCheckbox
	 */
	public WebElement getManufactureCheckbox() {
		return manufactureCheckbox;
	}

	/**
	 * @return the manufacturerDelete
	 */
	public WebElement getManufacturerDelete() {
		return manufacturerDelete;
	}

	public WebElement getManufacturerName() {
		return manufacturerName;
	}

	public WebElement getManufacturerEmail(String string, String string2) {
		return manufacturerEmail;
	}

	public WebElement getManufacturerPhone(String string, String string2) {
		return manufacturerPhone;
	}

	public WebElement getManufacturerUsername() {
		return manufacturerUsername;
	}

	public WebElement getManufacturerPassword() {
		return manufacturerPassword;
	}

	public WebElement getAddManufacturerButton() {
		return addManufacturerButton;
	}

	// Getters for Retailer Module
	public WebElement getRetailerLink() {
		return retailerLink;
	}

	public WebElement getRetailerUsername() {
		return retailerUsername;
	}

	public WebElement getRetailerPassword() {
		return retailerPassword;
	}

	public WebElement getAreacodeDropdown() {
		return areacodeDropdown;
	}

	public WebElement getRetailerPhone() {
		return retailerPhone;
	}

	public WebElement getRetailerEmail() {
		return retailerEmail;
	}

	public WebElement getRetailerAddress() {
		return retailerAddress;
	}

	public WebElement getAddRetailerButton() {
		return addRetailerButton;
	}

	// Methods to interact with Manufacturer Module
	public void addManufacturer(String name, String email, String phone, String username, String password) {
		manufacturerLink.click();
		manufacturerName.sendKeys(name);
		manufacturerEmail.sendKeys(email);
		manufacturerPhone.sendKeys(phone);
		manufacturerUsername.sendKeys(username);
		manufacturerPassword.sendKeys(password);
		addManufacturerButton.click();
	}

	// Methods to interact with Retailer Module
	public void addRetailer(String username, String password, String areacode, String phone, String email,
			String address) {
		retailerLink.click();
		retailerUsername.sendKeys(username);
		retailerPassword.sendKeys(password);
		areacodeDropdown.sendKeys(areacode);
		retailerPhone.sendKeys(phone);
		retailerEmail.sendKeys(email);
		retailerAddress.sendKeys(address);
		addRetailerButton.click();
	}

	public String getManufacturerMsgInAdminPage() {
		return manufacturerName.getText();
	}

	public String getRetailerMsgInAdminPage() {
		return retailerUsername.getText();
	}

	public void navigateToManufacturerList() {
		manufactureLink.click();

	}

	public void navigateToRetailerList() {
		retailerLink.click();
	}

	public WebElement searchManufacturer(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox")));
		searchBox.clear();
		searchBox.sendKeys(name);

		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton")));
		searchButton.click();

		// Wait for the search results to load and the manufacturer name to be visible
		WebElement manufacturer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//td[text()='" + name + "']")));

		return manufacturer;
	}

	public WebElement searchRetailer(String userName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox")));
		searchBox.clear();
		searchBox.sendKeys(userName);

		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton")));
		searchButton.click();

		WebElement retailer = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//td[text()='" + userName + "']")));

		return retailer; // Return the
	}

	public void addRetailer(String userName) {
		retailerUsername.sendKeys(userName);

	}

	public void editManufacturer(WebElement manufacturer, String newManufacturerName) {

		WebElement editButton = manufacturer.findElement(By.xpath(".//button[contains(text(), 'Edit')]"));
		editButton.click();

		WebElement nameInput = driver.findElement(By.id("manufacturerNameInput"));
		nameInput.clear();
		nameInput.sendKeys(newManufacturerName);
		WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(), 'Save')]"));
		saveButton.click();

	}

	public String getManufacturerAddress(String name,String newAddress) {
		
		WebElement manufacturerTable = driver.findElement(By.id("manufacturerTable"));
        List<WebElement> rows = manufacturerTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            
            WebElement nameCell = row.findElement(By.xpath(".//td[1]")); 
            if (nameCell.getText().equals(name)) {
        
                WebElement editButton = row.findElement(By.xpath(".//td//a[text()='Edit']")); 
                editButton.click();
                WebElement addressField = driver.findElement(By.id("addressInput")); 
                addressField.clear();
                addressField.sendKeys(newAddress);
                WebElement saveButton = driver.findElement(By.id("saveButton")); 
                saveButton.click();

                Alert alert = driver.switchTo().alert();
                alert.accept();
                return newAddress;
		
	}

        }
        
		return null;
	}

	public void addManufacturer(String name) {
		
		manufacturerName.sendKeys(name);
		
	}

	

}