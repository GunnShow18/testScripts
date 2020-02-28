package tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
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
	String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;
	
	// This is our test method
	@Test
	public void newAccountTest() {
		// Set WebDriver and open browser to webURL
		String webURL = "http://sdettraining.com/trguitransactions/NewAccount.aspx";
		WebDriver driver = utilities.DriverFactory.open("edge");
		driver.get(webURL);
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		// Define web elements
		WebElement nameBoxElement = driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailBoxElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneBoxElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		WebElement passwordBoxElement = driver.findElement(By.id("MainContent_txtPassword"));
		WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail")); 
		WebElement occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitElement = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// Fill out the Form
		nameBoxElement.sendKeys(name);
		emailBoxElement.sendKeys(email);
		phoneBoxElement.sendKeys(phone);
		// Selecting gender radio button
		if (gender.equalsIgnoreCase("male")) {driver.findElement(By.id("MainContent_Male")).click();} 
		else {driver.findElement(By.id("MainContent_Female")).click();}
				
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
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
		submitElement.click();
				 
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
	
}
