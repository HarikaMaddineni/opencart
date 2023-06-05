package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@Parameters("browser")
	@BeforeClass(groups= {"sanity","master","regression"})
	public void setUp(String br) {
		 rb=ResourceBundle.getBundle("config");
		logger=  LogManager.getLogger(this.getClass());
		if(br.equalsIgnoreCase("chrome")) {
			logger.info("Chrome driver Started");
			driver= new ChromeDriver();
			
		}else if(br.equalsIgnoreCase("edge")){
			logger.info("Edge browser started");
			driver= new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get(rb.getString("appURL"));
		logger.info("***************Opencart Application Started*************");
		
		
	}
	
	@AfterClass(groups= {"sanity","master","regression"})
	public void tearDown() {
		logger.info("***************Opencart Application closed*************");
		driver.quit();
		
	}
	
	public String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String generateRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
