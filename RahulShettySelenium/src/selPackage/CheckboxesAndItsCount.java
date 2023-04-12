package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesAndItsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());

		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(checkboxes.size());

		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
