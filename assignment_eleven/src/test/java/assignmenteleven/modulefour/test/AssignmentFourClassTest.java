package assignmenteleven.modulefour.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import assignmenteleven.moduleone.pages.SauceDemoLoginPage;
import assignmenteleven.moduleone.pages.SauceDemoLogoutPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFourClassTest {
 
	static WebDriver driver = null;
	static SauceDemoLoginPage login;
	static SauceDemoLogoutPage logout;
	static Logger log = Logger.getLogger(SauceDemoLogoutPage.class);
	static Logger logger = Logger.getLogger(SauceDemoLoginPage.class);
	
	@BeforeClass
	public void initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		login=PageFactory.initElements(driver,SauceDemoLoginPage.class);
		logout=PageFactory.initElements(driver, SauceDemoLogoutPage.class);
	}
	
	@Test(priority=1)
	public static void loginToSwagLabs()
	{	
		try {
			
		Properties property = new Properties();	
		
		FileInputStream file = new FileInputStream("src\\test\\resources\\com\\properties\\file\\loginfile.properties"); 
		property.load(file);
				
		String parentUrl = property.getProperty("parentUrl");
		String userName =property.getProperty("userName");
		String password = property.getProperty("passwordDemo");
		driver.get(parentUrl);
		login.loginSauceDemo(userName, password,parentUrl);
		String currentURL = driver.getCurrentUrl();
		log.info("successfully logged In ");	
		//Assert.assertNotEquals(currentURL, parentUrl);
		logout.logoutToSwagLabs();
		Thread.sleep(2000);
		currentURL= driver.getCurrentUrl();
		Assert.assertEquals(currentURL, parentUrl);
		logger.info("Successfully Logged Out ");
		
	}
		catch(Exception ex)
		{
			log.info(ex);
			logger.info(ex);
		}
	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
