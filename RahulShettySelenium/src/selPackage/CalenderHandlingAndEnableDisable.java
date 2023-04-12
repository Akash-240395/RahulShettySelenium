package selPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderHandlingAndEnableDisable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BOM']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
		/*
		 * try { driver.findElement(By.
		 * xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active'] ")).
		 * click(); } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("Continuing the execution"); }
		 */

		// Checking for Return date is enabled or not
		driver.findElement(By.cssSelector("#autosuggest")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Enabled");
			Assert.assertTrue(true);			
		}
		else {
			Assert.assertFalse(false);
		}
	}
	

}
