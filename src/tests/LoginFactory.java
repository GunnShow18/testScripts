package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.DashboardPageFactory;
import pages.LoginPageFactory;

public class LoginFactory {
	WebDriver driver;
	String username = "jv@testemail.com";
	String password = "jv4password";
	
	@Test
	public void LoginTestPageFactory() {
		
		// 1. Initialize the driver
		driver = utilities.DriverFactory.open("edge");
		System.out.println("Opening the webdriver.");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter login
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username,password);

		driver.quit();
	}
	


}
