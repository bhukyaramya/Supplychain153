package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public WebDriver driver=null;

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(className = "dvHeaderText")
//	private WebElement headerMsg;

//	public WebElement getHeaderMsg() {
//		return headerMsg;
//	}

//	@FindBy(className = "dtlview_Last Name")
//	private WebElement lastName;
//
//	public WebElement getLastName() {
//		return lastName;
//	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactBtn;

	public WebElement getContactBtn() {
		return createContactBtn;
	}

}
