package practice.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Example {

	@Test(dataProvider = "getDataFromExcel")
	public void getExcelDataTest(String brandName,String productName) {
		System.out.println("brandName:"+brandName+",productName:"+productName);

	}

	@DataProvider
	public void getDataFromExcel() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("product");

		Object[][] objArr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
		}
	}
	
}
