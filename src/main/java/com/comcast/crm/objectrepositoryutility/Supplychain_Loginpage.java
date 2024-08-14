package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Supplychain_Loginpage extends WebDriverUtility{

	WebDriverUtility wbLib=new WebDriverUtility();
	WebDriver driver;

	public Supplychain_Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtUsername")
	private WebElement textUsername;

	@FindBy(name = "txtPassword")
	private WebElement textPassword;
	
	@FindBy(name = "login_type")
	private WebElement logintype;
	
	@FindBy(name = "//img[@src='./images/logo/tekPyramidlogo.svg']")
	private WebElement imglogo;
      
	
	/**
	 * @return the imglogo
	 */
	public WebElement getImglogo() {
		return imglogo;
	}

	/**
	 * @param imglogo the imglogo to set
	 */
	public void setImglogo(WebElement imglogo) {
		this.imglogo = imglogo;
	}

	/**
	 * @return the logintype
	 */
	public WebElement getLogintype() {
		return logintype;
	}

	/**
	 * @param logintype the logintype to set
	 */
	public void setLogintype(WebElement logintype) {
		this.logintype = logintype;
	}

	// Rule 4 : Object Encapsulation
	/**
	 * @return the textUsername
	 */
	public WebElement getTextUsername() {
		return textUsername;
	}

	/**
	 * @param textUsername the textUsername to set
	 */
	public void setTextUsername(WebElement textUsername) {
		this.textUsername = textUsername;
	}

	/**
	 * @return the textPassword
	 */
	public WebElement getTextPassword() {
		return textPassword;
	}

	/**
	 * @param textPassword the textPassword to set
	 */
	public void setTextPassword(WebElement textPassword) {
		this.textPassword = textPassword;
	}

	@FindBy(xpath="//input[@class='submit_button']")
	private WebElement loginbtn;// Rule 3 : Object Initialization

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void loginToapp(String url, String username,String password) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		textUsername.sendKeys(username);
		textPassword.sendKeys(password);
		wbLib.select(logintype, "Admin");
		loginbtn.click();

	}

	
}
