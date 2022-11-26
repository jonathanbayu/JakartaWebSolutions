package step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import function.action;

public class purchase {
	static String projectpath = System.getProperty("user.dir");	
	static Properties objData = new Properties();
	static Properties objObjectHomepage = new Properties();	
	static Properties objObjectHeader = new Properties();	
	
	//Variable Verify
	String ProductName1,ProductPrice1,ProductName2,ProductPrice2,ProductName3,ProductPrice3;
	
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
	    action.TakeScreenshot(action.driver,"beforelogin "+action.timeStamp);
	    
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
		action.WaitUntil(By.xpath(objObjectHeader.getProperty("textAccount")));
		action.TakeScreenshot(action.driver,"afterlogin "+action.timeStamp);
	}

	@And("user open jacket category")
	public void user_open_jacket_category() throws IOException {
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryMen")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("cagetoryTops")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryJacket")));
	    action.TakeScreenshot(action.driver,"showmenucategory "+action.timeStamp);
	    action.driver.findElement(By.xpath(objObjectHomepage.getProperty("categoryJacket"))).click();
	    action.TakeScreenshot(action.driver,"jacketscatalog "+action.timeStamp);
	}
	
	@And("user buy jacket size XS and color black")
	public void user_buy_jacket_size_XS_and_color_black() throws InterruptedException{
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product1SizeXL"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product1ColorBlack"))).click();
		ProductName1 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName1"))).getText();
		ProductPrice1 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice1"))).getText();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonAddtoCart1"))).click();
		action.Wait(5);
	}
	
	@And("user buy another jacket size L and color red")
	public void user_buy_another_jacket_size_L_and_color_red() throws InterruptedException  {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product2SizeL"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product2ColorRed"))).click();
		ProductName2 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName2"))).getText();
		ProductPrice2 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice2"))).getText();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonAddtoCart2"))).click();
		action.Wait(5);
	}
	
	@And("user open pants category")
	public void user_open_pants_category() throws IOException {
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryMen")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("cagetoryBottom")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryPants")));
	    action.TakeScreenshot(action.driver,"showmenucategory "+action.timeStamp);
	    action.driver.findElement(By.xpath(objObjectHomepage.getProperty("categoryPants"))).click();
	    action.TakeScreenshot(action.driver,"pantsscatalog "+action.timeStamp);
	}
	
	@And("user buy pants size 32 and color black")
	public void And_user_buy_pants_size_32_and_color_black() throws InterruptedException {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product3Size32"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product3ColorBlack"))).click();
		ProductName3 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName3"))).getText();
		ProductPrice3 = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice3"))).getText();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonAddtoCart3"))).click();
		action.Wait(5);
	}
	
	@And("user proceed to checkout")
	public void user_proceed_to_checkout() throws IOException {
		action.driver.findElement(By.xpath(objObjectHeader.getProperty("buttonCart"))).click();
		action.driver.findElement(By.xpath(objObjectHeader.getProperty("buttonProccedtoCart"))).click();
		action.WaitUntil(By.xpath(objObjectHomepage.getProperty("fieldAddress")));
	}
	
	@And("user fill the form")
	public void user_fill_the_form() throws IOException {
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName3"))).getAttribute("aria-selected")=="false") {
			action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonHideShowSummary"))).click();
		}
		
		//Validating Product
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary1"))).getText()!=ProductName1) {
			action.TakeScreenshot(action.driver,"WrongProductName1");
			throw new Error("Product Name 1 is Wrong it should be "+ProductName1);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary2"))).getText()!=ProductName2) {
			action.TakeScreenshot(action.driver,"WrongProductName2");
			throw new Error("Product Name 2 is Wrong it should be "+ProductName2);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary3"))).getText()!=ProductName3) {
			action.TakeScreenshot(action.driver,"WrongProductName3");
			throw new Error("Product Name 3 is Wrong it should be "+ProductName3);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary1"))).getText()!="1") {
			action.TakeScreenshot(action.driver,"WrongProductQty1");
			throw new Error("Product Qty 1 is Wrong it should be 1");
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary2"))).getText()!="1") {
			action.TakeScreenshot(action.driver,"WrongProductQty2");
			throw new Error("Product Qty 2 is Wrong it should be 1");
		}

		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary3"))).getText()!="1") {
			action.TakeScreenshot(action.driver,"WrongProductQty3");
			throw new Error("Product Qty 3 is Wrong it should be 1");
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary1"))).getText()!=ProductPrice1) {
			action.TakeScreenshot(action.driver,"WarongProductPrice1");
			throw new Error("Product Qty 1 is Wrong it should be "+ProductPrice1);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary2"))).getText()!=ProductPrice2) {
			action.TakeScreenshot(action.driver,"WarongProductPrice2");
			throw new Error("Product Qty 2 is Wrong it should be "+ProductPrice2);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary3"))).getText()!=ProductPrice3) {
			action.TakeScreenshot(action.driver,"WarongProductPrice3");
			throw new Error("Product Qty 3 is Wrong it should be "+ProductPrice3);
		}
		
		action.TakeScreenshot(action.driver,"checkout "+action.timeStamp);
		
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldAddress"))).sendKeys(objData.getProperty("address"));
	}
	
	@And("user proceed to payments")
	public void user_proceed_to_payments() {
		
	}
	
	@And("user place an order")
	public void user_place_an_order() {
		
	}
	
	@And("user should see order number")
	public void user_should_see_order_number() {
		
	}	
	
}
