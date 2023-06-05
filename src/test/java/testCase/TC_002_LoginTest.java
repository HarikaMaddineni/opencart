

package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void login_test() {
		
		try {
			
			logger.info("*****************Login Test Started****************");
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		MyAccountPage myAcc= new MyAccountPage(driver);
		//myAcc.msgConfirmation();
		Assert.assertTrue(myAcc.msgConfirmation());
		Thread.sleep(1000);
		logger.info("*****************Login Test Finished****************");
		}
		catch(Exception ex) {
			Assert.fail();
		}
		
	}

}
