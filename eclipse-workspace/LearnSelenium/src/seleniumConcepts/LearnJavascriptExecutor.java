package seleniumConcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LearnJavascriptExecutor {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();  // Launch the chrome browser
		
		driver.manage().window().maximize();
		
		driver.get("https://phptravels.com/demo/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		WebElement emailTextBox = driver.findElement(By.id("address"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", emailTextBox);
		
		emailTextBox.sendKeys("John");

		js.executeScript("arguments[0].setAttribute('style','background: yellow;border: 2px solid red;');",
				emailTextBox);
		
		js.executeScript("arguments[0].style.border='4px solid red'", emailTextBox);
		
//		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@class='btn']")));
		
		
		String screenshot = "screenshot";
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\harishThadka\\Documents\\IntellijProjects\\eclipse-workspace\\LearnSelenium\\pictures\\"+
		screenshot+".png");
		
		FileHandler.copy(file, dest);

		Thread.sleep(3000);
		
		driver.quit();

	}

}
