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
	String ProductName1,ProductPrice1,ProductName2,ProductPrice2,ProductName3,ProductPrice3,OrderNumber;
	
	@BeforeAll
    public static void setup() throws IOException{
		
		FileInputStream objfileData = new FileInputStream(projectpath+"\\src\\test\\resources\\data\\data.properties");
		objData.load(objfileData);		
		
		FileInputStream objfileObjectHomepage = new FileInputStream(projectpath+"\\src\\test\\resources\\objects\\homepage.properties");
		objObjectHomepage.load(objfileObjectHomepage);		

		FileInputStream objfileObjectHeader = new FileInputStream(projectpath+"\\src\\test\\resources\\objects\\header.properties");
		objObjectHeader.load(objfileObjectHeader);	
	    
    }
	
	
	@Given("user visit homapage")
	public void user_is_on_login_page() throws IOException {		
	    
	    action.driver.get(objData.getProperty("baseUrl"));
	    action.driver.manage().window().maximize();
	    action.WaitUntil(By.xpath(objObjectHeader.getProperty("buttonSignIn")));
	    action.TakeScreenshot(action.driver,"1 beforelogin "+action.timeStamp);
	    
	}

	@When("user click sign in")
	public void user_click_sign_in() throws IOException {
		action.driver.findElement(By.xpath(objObjectHeader.getProperty("buttonSignIn"))).click();
		action.WaitUntil(By.xpath(objObjectHeader.getProperty("buttonSignIn")));		
	}

	@And("user input valid email and password")
	public void user_input_valid_email_and_password() throws IOException {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldEmail"))).sendKeys(objData.getProperty("email"));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldPassword"))).sendKeys(objData.getProperty("password"));
		action.TakeScreenshot(action.driver,"2 loginpage "+action.timeStamp);
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonSignIn"))).click();	
	}
	
	@And("user should see welcome message")
	public void user_should_see_welcome_message() throws IOException {
		action.WaitUntil(By.xpath(objObjectHeader.getProperty("textAccount")));
		action.TakeScreenshot(action.driver,"3 afterlogin "+action.timeStamp);
	}

	@When("user open jacket category")
	public void user_open_jacket_category() throws IOException {
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryMen")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("cagetoryTops")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryJacket")));
	    action.TakeScreenshot(action.driver,"4 showmenucategory "+action.timeStamp);
	    action.driver.findElement(By.xpath(objObjectHomepage.getProperty("categoryJacket"))).click();
	    action.TakeScreenshot(action.driver,"5 jacketscatalog "+action.timeStamp);
	}
	
	@And("user buy jacket size XS and color black")
	public void user_buy_jacket_size_XS_and_color_black() throws InterruptedException{
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product1SizeXL"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product1ColorBlack"))).click();
		ProductName1 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName1"))).getText()).trim();
		ProductPrice1 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice1"))).getText()).trim();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonAddtoCart1"))).click();
		action.Wait(5);
	}
	
	@And("user buy another jacket size L and color red")
	public void user_buy_another_jacket_size_L_and_color_red() throws InterruptedException  {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product2SizeL"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product2ColorRed"))).click();
		ProductName2 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName2"))).getText()).trim();
		ProductPrice2 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice2"))).getText()).trim();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonAddtoCart2"))).click();
		action.Wait(5);
	}
	
	@And("user open pants category")
	public void user_open_pants_category() throws IOException {
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryMen")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("cagetoryBottom")));
	    action.Hover(By.xpath(objObjectHomepage.getProperty("categoryPants")));
	    action.TakeScreenshot(action.driver,"6 showmenucategory "+action.timeStamp);
	    action.driver.findElement(By.xpath(objObjectHomepage.getProperty("categoryPants"))).click();
	    action.TakeScreenshot(action.driver,"7 pantsscatalog "+action.timeStamp);
	}
	
	@And("user buy pants size 32 and color black")
	public void And_user_buy_pants_size_32_and_color_black() throws InterruptedException {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product3Size32"))).click();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("product3ColorBlack"))).click();
		ProductName3 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductName3"))).getText()).trim();
		ProductPrice3 = (action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPrice3"))).getText()).trim();
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
		
		action.WaitUntil(By.xpath(objObjectHomepage.getProperty("fieldAddress")));
		
		if(Boolean.valueOf(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonHideShowSummary"))).getAttribute("aria-selected"))==false) {
			action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonHideShowSummary"))).click();
		}
		
		//Validating Product	
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary1"))).getText().equalsIgnoreCase(ProductName1) != true) {
			action.TakeScreenshot(action.driver,"WrongProductName1");
			throw new Error("Product Name 1 is Wrong it should be "+ProductName1);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary2"))).getText().equalsIgnoreCase(ProductName2) != true) {
			action.TakeScreenshot(action.driver,"WrongProductName2");
			throw new Error("Product Name 2 is Wrong it should be "+ProductName2);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductNameSummary3"))).getText().equalsIgnoreCase(ProductName3) != true) {
			action.TakeScreenshot(action.driver,"WrongProductName3");
			throw new Error("Product Name 3 is Wrong it should be "+ProductName3);
		}
		
		if(Integer.valueOf(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary1"))).getText())!=1) {
			action.TakeScreenshot(action.driver,"WrongProductQty1");
			throw new Error("Product Qty 1 is Wrong it should be 1");
		}
		
		if(Integer.valueOf(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary2"))).getText())!=1) {
			action.TakeScreenshot(action.driver,"WrongProductQty2");
			throw new Error("Product Qty 2 is Wrong it should be 1");
		}

		if(Integer.valueOf(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductQtySummary3"))).getText())!=1) {
			action.TakeScreenshot(action.driver,"WrongProductQty3");
			throw new Error("Product Qty 3 is Wrong it should be 1");
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary1"))).getText().equals(ProductPrice1) != true) {
			action.TakeScreenshot(action.driver,"WrongProductPrice1");
			throw new Error("Product Price 1 is Wrong it should be "+ProductPrice1);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary2"))).getText().equals(ProductPrice2) != true) {
			action.TakeScreenshot(action.driver,"WrongProductPrice2");
			throw new Error("Product Price 2 is Wrong it should be "+ProductPrice2);
		}
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textProductPriceSummary3"))).getText().equals(ProductPrice3) != true) {
			action.TakeScreenshot(action.driver,"WrongProductPrice3");
			throw new Error("Product Price 3 is Wrong it should be "+ProductPrice3);
		}
		
		action.TakeScreenshot(action.driver,"8 checkout "+action.timeStamp);	
		
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldAddress"))).sendKeys(objData.getProperty("address"));
		action.Select(objData.getProperty("country"), By.xpath(objObjectHomepage.getProperty("dropdownCountry")));
		action.Select(objData.getProperty("state"), By.xpath(objObjectHomepage.getProperty("dropdownState")));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldCity"))).sendKeys(objData.getProperty("city"));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldPostcode"))).sendKeys(objData.getProperty("postcode"));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("fieldPhone"))).sendKeys(objData.getProperty("phone"));
		action.WaitUntil(By.xpath(objObjectHomepage.getProperty("radiobuttonFreeDelivery")));
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("radiobuttonFreeDelivery"))).click();
		
		action.TakeScreenshot(action.driver,"9 filledcheckout "+action.timeStamp);		
		
	}
	
	@And("user proceed to payments")
	public void user_proceed_to_payments() {
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonProceedToPayment"))).click();
	}
	
	@And("user place an order")
	public void user_place_an_order() throws IOException, InterruptedException {
		//action.WaitUntil(By.xpath(objObjectHomepage.getProperty("buttonPlaceOrder")));
		action.Wait(10);
		action.TakeScreenshot(action.driver,"10 revieworder "+action.timeStamp);
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("buttonPlaceOrder"))).click();
	}
	
	@Then("user should see order number")
	public void user_should_see_order_number() throws IOException, InterruptedException {
		action.WaitUntil(By.xpath(objObjectHomepage.getProperty("textOrderNumber")));
		action.TakeScreenshot(action.driver,"11 ordersuccess "+action.timeStamp);
	}	
	
	@When("user open click order number")
	public void user_open_click_order_number() throws IOException {
		OrderNumber = action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textOrderNumber"))).getText().trim();
		action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textOrderNumber"))).click();		
	}
	
	@Then("user should see the order")
	public void user_should_see_the_order() throws IOException {
		action.WaitUntil(By.xpath(objObjectHomepage.getProperty("textHeaderOrders")));
		
		if(action.driver.findElement(By.xpath(objObjectHomepage.getProperty("textHeaderOrders"))).getText().contains(OrderNumber) != true) {
			action.TakeScreenshot(action.driver,"WrongOrderNumber");
			throw new Error("Order Number is Wrong it should be "+OrderNumber);
		}
		
		action.TakeScreenshot(action.driver,"12 orderspage "+action.timeStamp);
	}
	
}
