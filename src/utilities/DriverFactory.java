package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	// Key-Value pair variables
			static String geckoDriverKey = "webdriver.gecko.driver";
			static String geckoDriverPath = "\\C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\Software\\Drivers\\geckodriver.exe";
			static String chromeDriverKey = "webdriver.chrome.driver";
			static String chromeDriverPath ="\\C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\Software\\Drivers\\chromedriver.exe";
			static String baseUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
			static String edgeDriverKey = "webdriver.edge.driver";
			static String edgeDriverPath = "\\C:\\Users\\\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\Software\\Drivers\\msedgedriver.exe";
	
	// this method will return a web driver object
	public static WebDriver open(String browserType) {
		if (browserType.toLowerCase().equalsIgnoreCase("edge")) {
			// code for edge
			System.setProperty(edgeDriverKey, edgeDriverPath);
			System.out.println("Using Microsoft Edge Browser");
			return new EdgeDriver();
		} else if(browserType.toLowerCase().equalsIgnoreCase("firefox")) {
			// code for firefoxWebBrowser
			System.setProperty(geckoDriverKey, geckoDriverPath);
			System.out.println("Using Firefox Browser");
			return new FirefoxDriver();
		} else {
			// default to chromeWebBrowser
			System.setProperty(chromeDriverKey, chromeDriverPath);
			System.out.println("Using Chrome Browser");
			return new ChromeDriver();
			
		}
	}

}
