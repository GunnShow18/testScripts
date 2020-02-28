package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	
  @Test
  public void aTagsLinksTest() {
	  System.out.println("Running test");
	  boolean createAccountPresent = false;
	  
	  // We want to test the presence of A tags >> hyperlinks
	  List <WebElement> aElements = driver.findElements(By.tagName("a"));
	  
	  int numberOfAElements = aElements.size();
	  System.out.println("There are " + numberOfAElements + " a tags on the page.");
	  
	  for (WebElement aElement : aElements) {
		  System.out.println(aElement.getText());
		  if (aElement.getText().equals("CREATE ACCOUNT")) {
			  createAccountPresent = true;
			  break;
		  }
	  }
	  
  }
  
  @BeforeMethod
  public void setUp() {
	  System.out.println("Initializing web driver");
	  driver = utilities.DriverFactory.open("edge");
	  String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	  driver.get(webURL);
  }
  
  @AfterMethod
  public void tearDown() {
	  System.out.println("Closing the browser");
	  driver.close();
	  System.out.println("Terminating the driver");
	  driver.quit();
  }
}
