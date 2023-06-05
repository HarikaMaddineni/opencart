package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="input-firstname")WebElement txtfirstname;
	
	@FindBy(id="input-lastname")WebElement txtlastname;
	
	@FindBy(id="input-email")WebElement txtemail;
	
	@FindBy(id="input-telephone")WebElement txttelphn;
	@FindBy(id="input-password")WebElement txtpassword;
	@FindBy(id="input-confirm")WebElement txtcnfpassword;
	@FindBy(name="agree")WebElement chkpolicy;
	@FindBy(xpath="//input[@type='submit']")WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fName) {
		txtfirstname.sendKeys(fName);
	}
	public void setLastName(String lName) {
		txtlastname.sendKeys(lName);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String phoneNo) {
		txttelphn.sendKeys(phoneNo);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfPassword) {
		txtcnfpassword.sendKeys(cnfPassword);
	}
	public void setPrivacyPolicy() {
		chkpolicy.click();
	}
	public void clickContinue() {
		//sol1 
		btncontinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
		
	
}
