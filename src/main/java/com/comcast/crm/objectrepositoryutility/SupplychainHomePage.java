package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplychainHomePage {

	
	WebDriver driver;

	public SupplychainHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Add Products")
	private WebElement productLink;
	
	
	@FindBy(linkText = "Add Retailers")
	private WebElement retailerLink;
	
	
	@FindBy(linkText = "Add Distributor")
	private WebElement distributorLink;
	
	
	@FindBy(linkText = "Manage Unit")
	private WebElement manageUnit;
	
	@FindBy(linkText = "Manage Category")
	private WebElement manageCategory;
	
	@FindBy(linkText = "Manage Area")
	private WebElement manageArea;
	
	@FindBy(xpath = "//input[@class='submit_button']")
	private WebElement logoutButton;
	
	public WebElement getlogoutButton() {
		return logoutButton;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the productLink
	 */
	public WebElement getProductLink() {
		return productLink;
	}

	/**
	 * @return the retailerLink
	 */
	public WebElement getRetailerLink() {
		return retailerLink;
	}

	/**
	 * @return the distributorLink
	 */
	public WebElement getDistributorLink() {
		return distributorLink;
	}

	/**
	 * @return the manageUnit
	 */
	public WebElement getManageUnit() {
		return manageUnit;
	}

	/**
	 * @return the manageCategory
	 */
	public WebElement getManageCategory() {
		return manageCategory;
	}

	/**
	 * @return the maageArea
	 */
	public WebElement getMaageArea() {
		return manageArea;
	}
	
	
	
	public void logOut() {
		Actions act=new Actions(driver);
		act.moveToElement(logoutButton).perform();
		logoutButton.click();
		
	}
	
	 public void homePage() {
	        navigateToAddProducts();
	        navigateToAddRetailers();
	        navigateToAddDistributor();
	        navigateToManageUnit();
	        navigateToManageCategory();
	        navigateToManageArea();
	    }

	    private void navigateToAddProducts() {
	        productLink.click();
	        
	    }

	    private void navigateToAddRetailers() {
	        retailerLink.click();
	       
	    }

	    private void navigateToAddDistributor() {
	        distributorLink.click();
	        
	    }

	    private void navigateToManageUnit() {
	        manageUnit.click();
	        
	    }

	    private void navigateToManageCategory() {
	        manageCategory.click();
	        
	    }

	    private void navigateToManageArea() {
	        manageArea.click();
	       
	    }
	
}
