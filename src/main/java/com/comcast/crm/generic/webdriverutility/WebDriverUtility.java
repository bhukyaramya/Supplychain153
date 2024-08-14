package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementToPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnUrl(WebDriver driver,String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getTitle();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
	
	//are you used overloaded method in selenium Framework
	//Overloading mehtod to switch to Frame
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	//FRAME
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//ALERT
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismis(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//overloaded method For SELECT Class
	public void select(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	//ACTIONS Class
    public void mousemoveOnElement(WebDriver driver,WebElement element) {
    	Actions act = new Actions(driver);
			act.moveToElement(element).perform();
    }
    
    public void doubleclick(WebDriver driver,WebElement element) {
    	Actions act = new Actions(driver);
    	act.doubleClick(element).perform();
    }

	public String waitForAlertAndAccept(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.alertIsPresent()); 
	    driver.switchTo().alert().accept();
		return null;
	}

	public void scrollToElement(WebDriver driver, WebElement editButton) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", editButton);
		
	}
}
