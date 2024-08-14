package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestwithOutPom {

	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		//It will store element along with the address.
		WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2 = driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
		
		ele1.sendKeys("admin");
		ele2.sendKeys("root");
		
		//the username and password edit box getting erased bcoz of Refresh.
		//the element is their but in the backend the address of element geting changed bcoz of Refresh
		//my driver.findElement can not take the latest address after the Refresh during performing an action.
		//i.ee..the reason we never go for driver.findelement.
		driver.navigate().refresh();
		
		ele1.sendKeys("admin");
		ele2.sendKeys("root");
		
		ele3.click();
	}
}
