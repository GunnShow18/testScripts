package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// Key-Value pair variables
		String geckoDriverKey = "webdriver.gecko.driver";
		String geckoDriverPath = "\\C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\geckodriver.exe";
//		String chromeDriverKey = "webdriver.chrome.driver";
//		String chromeDriverPath ="\\C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\chromedriver.exe";
		String baseUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		// 1. Define the WebDriver
		System.setProperty(geckoDriverKey,geckoDriverPath);
		WebDriver driver = new FirefoxDriver();
		
		// 2. Open the browser and navigate to the web page
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(".btn-default")).click();
		
		// 3. Fill out the form
		
		// How to locate elements
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Hilliam Clinton");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("Hilliam.Clinton@WhiteHouse.gov");
		driver.findElement(By.xpath("//input[@id='MainContent_txtHomePhone']")).sendKeys("555-555-1555");
		driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("whoamama@ey2020");	
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("whoamama@ey2020");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Italy");
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click();
		
		String confirmation = driver.findElement(By.cssSelector("span[id='MainContent_lblTransactionResult']")).getText();
		System.out.println(confirmation);
		
		
		// 4. Get confirmation
		
		
		// 5. Close the browser
		
	}

}
