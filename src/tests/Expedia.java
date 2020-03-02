package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "fireFox";
	String webURL = "https://www.expedia.com/";
	String city = "New York, NY";
	String checkIn = "08/30/2020";
	String checkOut = "09/11/2020";
	String numOfGuests = "2";

	
	@Test
	public void hotelReservation() {
		//1. Search
		 driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		driver.findElement(By.cssSelector(".cols-nested:nth-child(15) .btn-primary")).click();
		driver.findElement(By.className("uitk-button-toggle-content")).click();
		}
		//2. Search
		
		//3. Search
		
	
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(webURL);	
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
		
	}

}
