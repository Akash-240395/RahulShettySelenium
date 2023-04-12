package selPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6_NoHardCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();
		String requiredOption = driver.findElement(By.cssSelector("label[for='benz']")).getText();

		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText(requiredOption);

		driver.findElement(By.id("name")).sendKeys(requiredOption);
		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains(requiredOption)) {
			Assert.assertTrue(true);
			System.out.println("Verified");
		} else
			Assert.assertTrue(false);
		
		driver.switchTo().alert().accept();
	}

}
