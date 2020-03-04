package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	//@Test
	public void loginTestPOM() {
	
	// 1. Initialize the driver
	WebDriver driver = utilities.DriverFactory.open("edge");
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	
	// 2. Enter login information (Login page)
	LoginPage loginPage = new LoginPage(driver);
	loginPage.setUserName("jv@testemail.com");
	loginPage.setPassword("jv4password");
	loginPage.clickSubmit();
	
	// 3. Get Confirmation (Dashboard Page)
	DashboardPage dashboardPage = new DashboardPage(driver);
	String conf = dashboardPage.confirmMessage();
	
	// 4. Assertions
	Assert.assertTrue(conf.contains("successfully"));
	
	// 5. Closer the driver
	driver.quit();
	}
}
