package demos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		// 1. Define the web driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		// 2. Open web browser and navigate to the web page
		//  http://obanksimulator.ngpf.org/index.php
		driver.get("http://obanksimulator.ngpf.org/index.php");
		
		// 3. Locate the element, determine the action, pass any parameters 
		driver.findElement(By.name("member_username")).sendKeys("JhonnyBravo20");
		// 4. Enter password
		driver.findElement(By.name("member_password")).sendKeys("whoamama");
		
		// 5. Click Login
		driver.findElement(By.name("submit_login")).click();
		
		// 6. Get confirmation
		String message = driver.findElement(By.id("select2-simul_month-container")).getText();
		System.out.println("CONFIRMATION: The month of " + message + " appears.");
		
		// getting page title
		String pageTitle = driver.getTitle();
		System.out.println("The page title is: " + pageTitle);
		
		// 7. Close the browser
		driver.close();
	}

}