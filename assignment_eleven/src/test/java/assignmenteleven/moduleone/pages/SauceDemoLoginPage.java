package assignmenteleven.moduleone.pages;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLoginPage {

	@FindBy(xpath="//input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pswd;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginButton;
	
	public void loginSauceDemo(String username,String password,String url) {
		
		
		userName.sendKeys(username);
		pswd.sendKeys(password);
		loginButton.sendKeys(Keys.RETURN);
		
	}
	
	public boolean verifyLogin(String currentURL,String parentUrl)
	{
		
		if(!(currentURL.equals(parentUrl)))
		{
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
