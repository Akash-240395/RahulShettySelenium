package selPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_rowsColumnsCountWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.linkText("PRACTICE")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 600)");
		
		int rows = driver.findElements(By.xpath("//table[@name='courses'] //tr")).size();
		System.out.println("Rows count:::: " +rows);
		 
		int columns = driver.findElements(By.xpath("//table[@name='courses'] //tr[1]/th")).size();
		System.out.println("Columns count:::: " +columns);
		
		System.out.println(driver.findElement(By.xpath("//table[@name='courses'] //tr[3]")).getText());

	}

}
