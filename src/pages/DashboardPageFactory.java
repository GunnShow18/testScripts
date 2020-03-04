package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {
	
WebDriver driver;
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	
	@FindBy(id="conf-message")
	WebElement confirmationText;
	
	
	public void changePassword() {
		changePasswordLink.click();
	}
	
	public String confirmMessage() {
		return confirmationText.getText();
	}
	
	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver;
		
	// Initialize web elements 
		PageFactory.initElements(driver, this);
	}

}
