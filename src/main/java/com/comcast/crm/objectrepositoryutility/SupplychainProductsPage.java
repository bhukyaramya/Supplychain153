package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplychainProductsPage {
	
	
	WebDriver driver;

	public SupplychainProductsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "product:name")
	private WebElement productName;
	
	@FindBy(id = "product:price")
	private WebElement productPrice;
	
	@FindBy(id = "product:unit")
	private WebElement prductUnit;
	
	@FindBy(id = "product:category")
	private WebElement producCategory;
	
	@FindBy(id = "product:category")
	private WebElement producCateory;
	
	@FindBy(xpath ="//input[@value='1']")
	private WebElement radioButtonenabled;
	
	@FindBy(xpath ="//input[@value='2']")
	private WebElement radioButtondisabled;
	
	@FindBy(id = "product:description")
	private WebElement productDescription;
	
	
	@FindBy(xpath = "//input[@class='submit_button']")
	private WebElement addproductButton;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}


	/**
	 * @return the productName
	 */
	public WebElement getProductName() {
		return productName;
	}


	/**
	 * @return the productPrice
	 */
	public WebElement getProductPrice() {
		return productPrice;
	}


	/**
	 * @return the prductUnit
	 */
	public WebElement getPrductUnit() {
		return prductUnit;
	}


	/**
	 * @return the producCategory
	 */
	public WebElement getProducCategory() {
		return producCategory;
	}


	/**
	 * @return the producCateory
	 */
	public WebElement getProducCateory() {
		return producCateory;
	}


	/**
	 * @return the radioButtonenabled
	 */
	public WebElement getRadioButtonenabled() {
		return radioButtonenabled;
	}


	/**
	 * @return the radioButtondisabled
	 */
	public WebElement getRadioButtondisabled() {
		return radioButtondisabled;
	}


	/**
	 * @return the productDescription
	 */
	public WebElement getProductDescription() {
		return productDescription;
	}


	/**
	 * @return the addproductButton
	 */
	public WebElement getAddproductButton() {
		return addproductButton;
	}
	

}
