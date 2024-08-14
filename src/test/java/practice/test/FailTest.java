package practice.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FailTest {

	
	@Test
	public void timeScreenShotTest() throws InterruptedException {
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://time.is/");

		System.out.println("Step-1");
		System.out.println("Step-2");
		SoftAssert sassert = new SoftAssert();
		sassert.assertEquals("Patel", "PatelGraphy");

		System.out.println("Step-3");
		System.out.println("Step-4");

		Thread.sleep(2000);
		sassert.assertAll();
		driver.close();
		

	}
}
