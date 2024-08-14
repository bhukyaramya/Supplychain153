package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductinfoTest(String brandName,String productName) {
		System.out.println("brandName:"+brandName+",productName:"+productName);
		/*
		 * WebDriver driver = new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get("https://www.amazon.com/");
		 * 
		 * // search product
		 * driver.findElement(By.xpath("twotabsearchtextbox")).sendKeys("iphone",
		 * Keys.ENTER);
		 * 
		 * // Capture Product Info String x = ""; String price =
		 * driver.findElement(By.xpath(x)).getText();
		 */

	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		
        ExcelUtility eLib = new ExcelUtility();
        int rowCount = eLib.getRowCount("product");
       // int colCount = eLib.get
        
        Object[][] objArr = new Object[rowCount][2];
        for(int i=0;i<rowCount;i++) {
        	//for(int j=0;j<colCount;j++) {
        		
        	
        	objArr[i][0] =eLib.getDataFromExcel("product", i+1, 0);
    		objArr[i][1] =eLib.getDataFromExcel("product", i+1, 1);
        }
         	
//		Object[][] objArr = new Object[3][3];
//		objArr[0][0] = "iphone";
//		objArr[0][1] = "Apple iPhone 15 (128 GB) - Black";
//
//		objArr[1][0] = "iphone";
//		objArr[1][1] = "Apple iPhone 13 (128GB) - Midnight";
//
//		objArr[2][0] = "iphone";
//		objArr[2][1] = "Apple iPhone 15 Pro (256 GB) - Blue Titanium";

		return objArr;

	}
}
