package practice.test;
/**
 * test class for contact module
 * @author Ramya Bhukya
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.genericutility.BaseClass;

public class SearchContactTest extends BaseClass{
	/**
	 * 
	 * scenario : login()==> navigateContact==>createcontact()==verify
	 */
	@Test
	public void searchcontacttest() {
		/*step1 : login to app*/
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "password");
	}

}
