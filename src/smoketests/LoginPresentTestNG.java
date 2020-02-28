package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email textbox present");
		Assert.assertTrue(!passwordBox, "Password textbox not present");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing driver");
		driver = utilities.DriverFactory.open("edge");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webURL);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.close();
		System.out.println("Terminating the driver");
		driver.quit();
	}
	
}
