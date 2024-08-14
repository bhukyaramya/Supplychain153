package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericutility.BaseClass;

public class InvoiceTest extends BaseClass {
	// @Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
//	public class InvoiceTest{
//	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
//	public void activeSim() {
//	
//		System.out.println("execute createInvoiceTest");
//		Assert.assertEquals("", "Login");
//		System.out.println("Step-1");
//		System.out.println("Step-2");
//		System.out.println("Step-3");
//		System.out.println("Step-4");
//	}

	@Test
	public void createInvoieTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	@Test
	public void createInvoiewithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
