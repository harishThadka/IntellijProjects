package seleniumConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();  // Launch the chrome browser
		
		driver.manage().window().maximize();
		
		driver.get("https://phptravels.com/demo/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		
		windowHandling();
		
		Thread.sleep(1000);
		
		driver.quit();
	}
	
	
	public static void windowHandling() {
		
		Set<String> handlers = driver.getWindowHandles();
		
		Iterator<String> it = handlers.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		System.out.println("Parent: "+parent+" Child: "+child);
		
		driver.switchTo().window(child);
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println("Child Url: "+currentUrl);
	
		driver.close();
		
		driver.switchTo().window(parent);
		
		currentUrl = driver.getCurrentUrl();
		
		System.out.println("Current Url: "+currentUrl);	
		
	}

}
