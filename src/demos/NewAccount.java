package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String baseUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String name = "Bill Clinton";
		String email = "Bill.Clint@dawhitehouse.gov";
		String password = "whoamama@ey2020";
		String gender = "MALE";
		String country = "Italy";
		String browserType = "edGE";
		String phoneNumber = "555-555-5555";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = false;
		
		// Define WebDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
	
		
		// Open the declared browser, navigate to the web page, click submit button
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(".btn-default")).click();
		
		// Web Elements must be declared as if the page is open on those page elements
				WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
				WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
				WebElement homePhoneElement = driver.findElement(By.xpath("//input[@id='MainContent_txtHomePhone']"));
				WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
				WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
				WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
				WebElement femaleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
				WebElement maleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']"));
				WebElement weeklyEmailElement = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
				WebElement monthlyEmailElement = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
				WebElement occasionalEmailElement = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
				
		// Fill out the form
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		homePhoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);	
		verifyPasswordElement.sendKeys(password);
		
		// Gender Select Algorithm
		if (gender.equalsIgnoreCase("female")) {
			femaleRadioElement.click();
		} else {
			maleRadioElement.click();
		}
		
		// Select Country
		new Select(countryElement).selectByVisibleText(country);
		
		 // Email interval check boxes
		if (weeklyEmail) {
			if(!weeklyEmailElement.isSelected()) {
				weeklyEmailElement.click();
			}
		} else {
			if (weeklyEmailElement.isSelected()) {
				weeklyEmailElement.click();
			}
		}
		if (monthlyEmail) {
			if (!monthlyEmailElement.isSelected()) {
				monthlyEmailElement.click();
			}
		} else {
			if (monthlyEmailElement.isSelected()) {
				monthlyEmailElement.click();
			}
		}
		if (occasionalEmail) {
			if (!occasionalEmailElement.isSelected()) {
				occasionalEmailElement.click();
			}
		} else {
			if (occasionalEmailElement.isSelected()) {
				occasionalEmailElement.click();
			}
		}
		
		
		
		//Submit Button
		driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click();
		
		
		// Get confirmation & Close Browser
		String confirmation = driver.findElement(By.cssSelector("span[id='MainContent_lblTransactionResult']")).getText();
		String expected = "Customer information added successfully";
		if (confirmation.contains(expected)) {
			System.out.println("CONFIRMATION: " + confirmation);
			driver.close();
			System.out.println("Closed window");
			driver.quit();
			System.out.println("Terminated driver instance");
		} else {
			System.out.println("Script error: TEST FAILED");
			driver.close();
			System.out.println("Closed window");
			driver.quit();
			System.out.println("Terminated driver instance");
		}
	}
}
