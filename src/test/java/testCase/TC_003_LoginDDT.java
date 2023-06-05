package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "login_data",dataProviderClass =  DataProviders.class)
	
	public void login_DDT(String username,String password,String exp) {
				try {
					
					logger.info("*****************Login Test DDT started****************");
				HomePage hp =new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(username);
				lp.setPassword(password);
				lp.clickLogin();
				MyAccountPage myAcc= new MyAccountPage(driver);
				boolean targetpage = myAcc.msgConfirmation();// this method is created MyAccountPage

				if (exp.equals("Valid")) {
					if (targetpage == true) {
						myAcc.clickLogout();
						Assert.assertTrue(true);
					} else {
						Assert.assertTrue(false);
					}
				}

				if (exp.equals("Invalid")) {
					if (targetpage == true) {
						MyAccountPage myaccpage = new MyAccountPage(driver);
						myaccpage.clickLogout();
						Assert.assertTrue(false);
					} else {
						Assert.assertTrue(true);
					}
				}

			} catch (Exception e) {
				Assert.fail();
			}

			logger.info(" Finished TC_003_LoginDataDrivenTest");
	}

}
