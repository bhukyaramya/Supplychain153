package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDistributorPage {
	
	
	WebDriver driver;
	 public AddDistributorPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 @FindBy(xpath="//a[@href='../admin/add_distributor.php']")
	 private WebElement distributorLink;
	 
	 @FindBy(id="distributor:name")
	 private WebElement distributorName;
	 
	 @FindBy(id="distributor:email")
	 private WebElement distributorEmail;
	 
	 
	 @FindBy(id="distributor:phone")
	 private WebElement distributorPhone;
	 
	 @FindBy(id="distributor:address")
	 private WebElement distributorAddress;
	 
	 @FindBy(xpath="//input[@type='submit']")
	 private WebElement addDistributorbutton;
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the distributorLink
	 */
	public WebElement getDistributorLink() {
		return distributorLink;
	}

	/**
	 * @return the distributorName
	 */
	public WebElement getDistributorName() {
		return distributorName;
	}

	/**
	 * @return the distributorEmail
	 */
	public WebElement getDistributorEmail() {
		return distributorEmail;
	}

	/**
	 * @return the distributorPhone
	 */
	public WebElement getDistributorPhone() {
		return distributorPhone;
	}

	/**
	 * @return the distributorAddress
	 */
	public WebElement getDistributorAddress() {
		return distributorAddress;
	}

	/**
	 * @return the addDistributorbutton
	 */
	public WebElement getAddDistributorbutton() {
		return addDistributorbutton;
	}
	
	public void addDistributor(String name, String email, String mobile, String address) {
       
        distributorLink.click();

        distributorName.clear();
        distributorName.sendKeys(name);

        distributorEmail.clear();
        distributorEmail.sendKeys(email);

        distributorPhone.clear();
        distributorPhone.sendKeys(mobile);

        distributorAddress.clear();
        distributorAddress.sendKeys(address);
        addDistributorbutton.click();
    }
	
	
	public WebElement searchDistributor(String name) {
	    WebElement searchBox = driver.findElement(By.id("searchBox")); 
	    searchBox.clear(); 
	    searchBox.sendKeys(name); 

	    WebElement searchButton = driver.findElement(By.id("searchButton")); 
	    searchButton.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement distributor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//td[text()='" + name + "']")));
	    
	    return distributor;
	}

	public boolean isDistributorPresent(String name) {
		distributorName.sendKeys(name);
		return false;
		

	}

}
