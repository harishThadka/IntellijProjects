package seleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnWebDriver {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();  // Launch the chrome browser
		
		driver.manage().window().maximize();
		
//		Thread.sleep(2000);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
//		driver.get("https://uat1.online.citi.com");
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
//		String currentUrl = driver.getCurrentUrl();
//		
//		String title = driver.getTitle();
//		
//		System.out.println("Current url is "+currentUrl);
//		
//		System.out.println("Title is "+title);
//		
//		driver.findElement(By.xpath("//*[@id=\"username\"]"))
//		.sendKeys("uat_123");
//		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		
//		System.out.println("Links Count: "+linksList.size());
//		
//		for(WebElement link: linksList) {
//			System.out.println(link.getText());
//		}
		
//		String expectedValue = "Username cannot be empty";
//		
//		driver.findElement(By.className("button")).click();
//		
//		String actualValue = driver.findElement(By.xpath("//*[@id=\"spanMessage\"]"))
//				.getText();
//		
//		if(actualValue.equals(expectedValue)) {
//			System.out.println("Username is required");
//		}
//		
//		Thread.sleep(1000); 
		
//		driver.findElement(By.linkText("Forgot your password?")).click();
		
//		driver.findElement(By.xpath("//*[contains(text(),'LOGIN')]")).click();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.className("button")).click();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[contains(text(),'Recruitment')]")).click();
		
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='candidateSearch[jobVacancy]']"));
		
		dropDown.click();
		
		Select sel = new Select(dropDown);
				
		sel.selectByIndex(2);
		
		dropDown.click();
		
		Thread.sleep(2000);
		
		sel.selectByVisibleText("Software Engineer");
		
		dropDown.click();
		
		Thread.sleep(2000);
		
		sel.selectByValue("4");
		
		dropDown.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
	
	

}
