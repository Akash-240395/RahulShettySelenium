package selPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//WebDriverWait wt = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		
		// Switching windows
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		for (String windowID : windows) {
			System.out.println(windowID);			
		}
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		String username = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(username);
		
		
		

	}

}
