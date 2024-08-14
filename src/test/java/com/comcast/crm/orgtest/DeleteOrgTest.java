//package com.comcast.crm.orgtest;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.PageFactory;
//
//import com.comcast.crm.generic.fileutility.ExcelUtility;
//import com.comcast.crm.generic.fileutility.FileUtility;
//import com.comcast.crm.generic.webdriverutility.JavaUtility;
//import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
//import com.comcast.crm.objectrepositoryutility.HomePage;
//import com.comcast.crm.objectrepositoryutility.LoginPage;
//import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
//import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
//
//public class DeleteOrgTest {
//
//	public static void main(String[] args) throws Throwable {
//
//		/* create Object */
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wlib = new WebDriverUtility();
//		
//		
//		
//	    // read common data from Property file
//        String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		
//		// Read testscript data from Excel file
//		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
//         
//          
//          
//		WebDriver driver = null;
//		// polymorphism concept
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		// step1: login to app
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(URL);
//
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToapp("admin", "root");
//		//instead of accessing the element iam going to use getters method
////		lp.getUsernameEdt().sendKeys("admin");
////		lp.getPasswordEdt().sendKeys("manager");
////		lp.getLoginbtn().click();
//		
//		
//		//first approach
////		lp.usernameEdt.sendKeys("admin");
////		lp.passwordEdt.sendKeys("root");
////		lp.loginbtn.click();
//
//		// step 2 :navigate organization module
//		HomePage hp = new HomePage(driver);
//		hp.getOrgLink().click();
//		
//		
//		// step3 :click on "create organization module
//		OrganizationsPage orgpage=new OrganizationsPage(driver);
//		orgpage.getCreateNewOrgBtn().click();
//
//		// step 4: enter all the details and create new Organization
//		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//		cnop.createOrg(orgName);
//		
//		
//		//verify Header msg Expected Result
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		String actOrgName = oip.getHeaderMsg().getText();
//		
//		if(actOrgName.contains(orgName)) {
//			
//			System.out.println(orgName+"name is verified==PASS");
//		}else {
//			System.out.println(orgName+"name is not verified==FAIL");
//		}
//		
//		
//		//Go back To org page
//		
//		hp.getOrgLink().click();
//		
//		
//		
//		
//		//Search for Organization,
//		orgpage.getSearchEdt().sendKeys(orgName);
//		wlib.select(orgpage.getSearchDD(), "Organization Name");
//		orgpage.getSearchBtn().click();
//		
//		
//		//In dynamic webTable Select and delete Org
//		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
//		
//		// step5 : logout
//		//hp.logout();
//		
//		//driver.quit();
//
//	}
//
//}
