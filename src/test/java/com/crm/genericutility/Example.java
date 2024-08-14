package com.crm.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example {

	@Test(invocationCount = 2, threadPoolSize = 2)
	public void createContact() {
		WebDriver driver = new FirefoxDriver();

	}

}
