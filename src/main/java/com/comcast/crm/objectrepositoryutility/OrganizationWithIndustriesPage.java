package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationWithIndustriesPage {

	
	WebDriver driver;
	public OrganizationWithIndustriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	
	public WebElement getIndustryDB() {
		return industryDB;
	}
	
	@FindBy(name = "accounttype")
	private WebElement accountTypeDB;
	
	
	public WebElement getAccountTypeDB() {
		return accountTypeDB;
	}
	
	
}
