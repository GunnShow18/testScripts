package tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone);
		if (phone.equals("7894561230")) {
			Assert.fail();
		}
	}
	
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\Users\\SQ363ZW\\Desktop\\EY Projects\\Selenium WebDriver\\original.csv");
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
}
