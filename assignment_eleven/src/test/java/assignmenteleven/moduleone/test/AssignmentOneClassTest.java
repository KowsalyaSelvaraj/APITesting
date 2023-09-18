package assignmenteleven.moduleone.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import assignmenteleven.moduleone.pages.SauceDemoLoginPage;

import java.time.Duration;
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

public class AssignmentOneClassTest {
 
	static WebDriver driver = null;
	static SauceDemoLoginPage login;
	@BeforeClass
	public void initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		login=PageFactory.initElements(driver,SauceDemoLoginPage.class);
	}
	
	@Test
	public static void loginToSwagLabs()
	{
		
		
		String parentUrl = "https://www.saucedemo.com/";
		String userName ="standard_user";
		String password = "secret_sauce";
		driver.get(parentUrl);
		login.loginSauceDemo(userName, password,parentUrl);
		String currentURL = driver.getCurrentUrl();
		Assert.assertNotEquals(currentURL,parentUrl);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
