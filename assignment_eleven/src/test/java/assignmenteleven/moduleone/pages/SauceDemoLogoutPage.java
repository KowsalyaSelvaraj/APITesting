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

public class SauceDemoLogoutPage {

	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement sideTab;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logOutbutton;
		
	public void logoutToSwagLabs() {
		
		sideTab.click();
		logOutbutton.click();
		
	}
	
	
}
