package tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameBoxElement, emailBoxElement, phoneBoxElement, passwordBoxElement, verifyPasswordElement, countryElement, weeklyEmailElement, monthlyEmailElement, occasionalEmailElement, submitElement;
	WebDriver driver;
	
	// This is our test method
	@Test
	public void newAccountTest() {
		//Print record to console
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
				
		// Define web elements
		defineWebElements();
				
		// ******-----------------------Fill out the Form------------------------------->>>>>>
		
		nameBoxElement.sendKeys(name);
		emailBoxElement.sendKeys(email);
		phoneBoxElement.sendKeys(phone);
		// Selecting gender radio button
		if (gender.equalsIgnoreCase("male")) {driver.findElement(By.id("MainContent_Male")).click();} 
		else {driver.findElement(By.id("MainContent_Female")).click();}
		//Entering password and verifying password
		passwordBoxElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		// Selecting Country
		new Select(countryElement).selectByVisibleText(country);
		// Selecting Email Interval Preference
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
		// Submitting form
//		submitElement.click();
				 
	}
	
	// This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\original.csv");
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if (weeklyEmail.equalsIgnoreCase("True")) {this.weeklyEmail = true;} 
		else {this.weeklyEmail = false;}
		
		if (monthlyEmail.equalsIgnoreCase("True")) {this.monthlyEmail = true;} 
		else {this.monthlyEmail = false;}
		
		if (occasionalEmail.equalsIgnoreCase("True")) {this.occasionalEmail = true;} 
		else {this.occasionalEmail = false;}
	}
	
	@Before
	public void setUp() {
		// Set WebDriver and open browser to webURL
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = utilities.DriverFactory.open("edge");
		driver.get(webURL);
		driver.findElement(By.cssSelector(".btn-default")).click();
	}
	
	@After
	public void tearDown() {
		driver.close();
		System.out.println("Closing web browser.");
		driver.quit();
		System.out.println("Terminating driver instance");
	}
	
	public void defineWebElements() {
		// Define web elements
				nameBoxElement = driver.findElement(By.id("MainContent_txtFirstName"));
				emailBoxElement = driver.findElement(By.id("MainContent_txtEmail"));
				phoneBoxElement = driver.findElement(By.id("MainContent_txtHomePhone"));
				passwordBoxElement = driver.findElement(By.id("MainContent_txtPassword"));
				verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
				countryElement = driver.findElement(By.id("MainContent_menuCountry"));
				weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
				monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail")); 
				occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
				submitElement = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
}
