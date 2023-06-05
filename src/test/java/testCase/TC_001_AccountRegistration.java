package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	@Test(groups= {"sanity","master"})
	public void test_account_Registration() {
		logger.info("Account Registartion stated"+this.getClass());
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		//regPage.set+FirstName("hari");
		regPage.setFirstName(generateRandomString());
		regPage.setLastName(generateRandomString());
		regPage.setEmail(generateRandomString()+"@gmail.com");
		regPage.setTelephone(generateRandomNumber());
		String passWord=generateRandomString();
		regPage.setPassword(passWord);
		regPage.setConfirmPassword(passWord);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		String msg= regPage.getConfirmationMsg();
		logger.info("verifying customer registration");
		
		if(msg.equals("Your Account Has Been Created!"))
		{
			
			logger.info("test passed..");
			Assert.assertTrue(true);
	
		}
		else
		{
			logger.warn("customer registration is not successful");
			logger.error("test failed..");
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	
	

}
