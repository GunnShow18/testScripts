package stepImplementations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class BDDLoginTest {
	WebDriver driver;
	
	String baseURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	String browserType = "edge";
	String userName = "ep@testemail.com";
	String passWord = "ep1password";
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page( ) {
		System.out.println("User is on the login page");
		driver = utilities.DriverFactory.open(browserType);
		driver.get(baseURL);
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password( ) {
		System.out.println("User enters correct username and correct password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(userName);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(passWord);
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@When("^user enters email (.*)$")
	public void user_enters_username(String username ) {
		System.out.println("TESTING: " + username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password(String password) {
		System.out.println("TESTING: " + password);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		click_login();
	}
	
	//@And("^user clicks login button$")
	public void click_login() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation");
		String conf = driver.findElement(By.id("conf_message")).getText();
		Assert.assertTrue(conf.contains("Logged in successfully"));	
		
	}
	
	@After
	public void tearDown( ) {
		driver.quit();
	}

}
