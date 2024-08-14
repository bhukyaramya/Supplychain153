package com.comcast.crm.objectrepositoryutility;
/**
 * 
 *@author Ramya Bhukya
 * 
 *contains Login Page elements and business lib like login() 
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility { // Rule1- create a seperate java class

	// Rule2-create a Object
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdt;

	// Rule 4 : Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	@FindBy(id = "submitButton")
	private WebElement loginbtn;// Rule 3 : Object Initialization

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	/**
	 * login to app based on Username, password ,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */

	// run 5 :provide Action
	public void loginToapp(String url, String username,String password) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();

	}

	

}
