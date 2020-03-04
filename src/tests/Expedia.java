package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;	
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "edge";
	String webURL = "https://www.expedia.com/";
	String city = "New York, NY";
	String checkIn = "08/30/2020";
	String checkOut = "09/11/2020";
	String searchResult = "2";

	
	@Test
	public void hotelReservation() {
		//1. Search
		 driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		driver.findElement(By.cssSelector(".cols-nested:nth-child(15) .btn-primary")).click();
		// print the name of the city
		String actualCity = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/div/section/div/form/div[1]/div/div/button[1]")).getText();
		System.out.println("CITY: " + actualCity);
		//2. Modify the search results page, give star-rating criteria
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/main/div/div/div[1]/section/form/fieldset[4]/div/div/div[5]/label/span[1]")).click();
		
		//3. Analyze the results page, give criteria
		
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/main/div/div/div[2]/section[2]/ol/li[3]/div/div/a")).click();
//		driver.findElement(By.cssSelector(".listing:nth-child(1) .listing__link")).click();
		
		WebElement firstHotel = driver.findElement(By.cssSelector(".listing:nth-child(1) .listing__link"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firstHotel.click();
		

		
		// Switch to the window to the top
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// Confirm windows have switched
		String hotelName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/section/div[1]/div/div[2]/div[1]/div/div[1]/h1")).getText();
		String hotelRating = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/main/div[1]/div[1]/div/div/section[1]/section/div/span")).getText();
		System.out.println("HOTEL : " + hotelName + "\n"
				+ "RATING: " + hotelRating);
		
		// 4. Book reservation
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/main/div[1]/section/"
				+ "ul/li[1]/div/section/div/div[2]/div/section[1]/div/div[2]/div[2]/div/form/button/span/span")).click();
		String hotelPrice = driver.findElement(By.cssSelector("span[class='amount-value summary-total  ']")).getText();
		System.out.println("The price is: " + hotelPrice);
		
		// 5. Fill out contact / billing
		// Would highlight fields and enter data if I were to actually purchase the hotel room.
		
		// 6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(webURL);	
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
