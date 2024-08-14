package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationWithPhonenumberPage {

	WebDriver driver;
	public OrganizationWithPhonenumberPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	@FindBy(name="phone")
	private WebElement createPhone;
	
	public WebElement getCreatePhone() {
		return createPhone;
	}

	public void createOrg(String orgName,String industry) {
		
		createPhone.sendKeys(orgName);
		Select sel = new Select(createPhone);
		sel.selectByVisibleText(industry);
		
		//saveBtn.click();
	}
	
	
}
