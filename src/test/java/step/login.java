package step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import function.action;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
/*
public class login {
	static String projectpath = System.getProperty("user.dir");	
	static Properties objData = new Properties();
	static Properties objObjectHomepage = new Properties();	
	static Properties objObjectHeader = new Properties();	
	
	//Variable Verify
	String ProductName1 = null;
	
	@BeforeAll
    public static void setup() throws IOException{
		
		FileInputStream objfileData = new FileInputStream(projectpath+"\\src\\test\\resources\\data\\data.properties");
		objData.load(objfileData);		
		
		FileInputStream objfileObjectHomepage = new FileInputStream(projectpath+"\\src\\test\\resources\\objects\\homepage.properties");
		objObjectHomepage.load(objfileObjectHomepage);		

		FileInputStream objfileObjectHeader = new FileInputStream(projectpath+"\\src\\test\\resources\\objects\\header.properties");
		objObjectHeader.load(objfileObjectHeader);	
		
	    //System.setProperty("webdriver.chrome.driver", projectpath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
	    
    }
	
	
	@Given("user visit homapage")
	public void user_is_on_login_page() throws IOException {		
	    
	    action.driver.get(objData.getProperty("baseUrl"));
	    action.driver.manage().window().maximize();
	    action.WaitUntil(By.xpath(objObjectHeader.getProperty("buttonSignIn")));
	    action.TakeScreenshot(action.driver,"homepage "+action.timeStamp);
	    
	}

	@When("user click sign in")
	public void user_click_sign_in() throws IOException {
		action.driver.findElement(By.xpath(objObjectHeader.getProperty("buttonSignIn"))).click();
		action.WaitUntil(By.xpath(objObjectHeader.getProperty("buttonSignIn")));
		action.TakeScreenshot(action.driver,"loginpage "+action.timeStamp);
	}

	@And("user input valid email and password")
	public void user_input_valid_email_and_password() throws IOException {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldEmail"))).sendKeys(objData.getProperty("email"));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldPassword"))).sendKeys(objData.getProperty("password"));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonSignIn"))).click();
	}
	
	@Then("user should see welcome message")
	public void user_should_see_welcome_messag() throws IOException {
		action.WaitUntil(By.xpath(objObjectHeader.getProperty("textAccount")));
		action.TakeScreenshot(action.driver,"afterlogin "+action.timeStamp);
	}
}
*/
