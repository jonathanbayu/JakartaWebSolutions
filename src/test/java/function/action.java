package function;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class action {
	public static WebDriver driver = new ChromeDriver();
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	static LocalDateTime dateTime = LocalDateTime.now();
    public static String timeStamp = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").format(dateTime);
	
	public static void TakeScreenshot(WebDriver driver, String FileName) throws IOException {
		String ScreenshotPath = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\";
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(ScreenshotPath+FileName+".png"), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void WaitUntil(By Path) throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Path));
	}	
	
	public static void Wait(int Second) throws InterruptedException {
		Thread.sleep(Second * 1000);
	}	
	
	public static void Hover(By Path) throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(Path)).perform();
	}	
	
	public static void Select(String string, By Path) throws IOException {
		Select selectString = new Select(driver.findElement(Path));
		selectString.selectByVisibleText(string);
	}	
}
