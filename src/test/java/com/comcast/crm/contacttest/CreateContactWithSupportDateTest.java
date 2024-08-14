package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {

		/* create Object */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		// read common data from Property file

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

				
		WebDriver driver = null;
		// polymorphism concept
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		//Read data from Excel
		String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
		//String PhoneNum=eLib.getDataFromExcel("contact", 7, 3);
		
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(20);

		//Step 1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);

		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);

		//Step 2: navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		//Step 3: Click on "create Contact" Button
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactBtn().click();

		//Step 4: enter last name and create new contact and date
		String endDate1 = jLib.getSystemDateYYYYDDMM();
		String startDate1 = jLib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createLastName(lastName, startDate, endDate);
	
				
				//verify start date
				String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actStartDate.contains(startDate1))
				{
					System.out.println(startDate1+" this is verified == PASS");
				}
				else
				{
					System.out.println(startDate1+" this is not verified == FAIL");
				}
				
				//verify end date
				String actEndDate =driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actEndDate.contains(endDate1))
				{
					System.out.println(endDate1+" this is verified == PASS");
				}
				else
				{
					System.out.println(endDate1+" this is not verified == FAIL");
				}
				
				System.out.println(endDate1+"<==========="+actEndDate);
				hp.logout();
				
				driver.quit();
			}

		}

	
	
