package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorForScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 600)");
		
		Thread.sleep(3000);
		
		jse.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List <WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		System.out.println(values.size());
		
		int sum = 0;
		
		for(int i=0; i<values.size(); i++) {
			int value = Integer.parseInt(values.get(i).getText());
			sum = sum + value;
		}
		System.out.println("Sum of all values is:::: " +sum);
		
		String givenSum = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		
		Assert.assertEquals(sum, Integer.parseInt(givenSum));
		System.out.println("Sum matched givenSum");

	}

}
