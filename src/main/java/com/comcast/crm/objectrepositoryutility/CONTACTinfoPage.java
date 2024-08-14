package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CONTACTinfoPage {
	
	
	WebDriver driver;

	public CONTACTinfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement HeaderMsg;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameHeaderMsg;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateMsg;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateMsg;

	@FindBy(name = "account_name")
	private WebElement infoOrgName;

	public WebElement getLastNameHeaderMsg() {
		return lastNameHeaderMsg;
	}

	public WebElement getHeaderMsg()
	{
		return HeaderMsg;
	}
	public WebElement getStartDateMsg() {
		return startDateMsg;
	}

	public WebElement getEndDateMsg() {
		return endDateMsg;
	}

	public WebElement getinfoOrgName() {
		return infoOrgName;
	}

}